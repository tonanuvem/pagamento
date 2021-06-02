# https://docs.aws.amazon.com/pt_br/elasticbeanstalk/latest/dg/iam-servicerole.html
sh config_credenciais.sh
echo ""
echo " Configurando ..."
docker run -ti --rm --name awscli -v $PWD/files/:/root/.aws -v $PWD/iam/:/fiap --entrypoint /bin/sh -d tonanuvem/kubectl-aws-cli
#docker run -ti --rm --name kubectl -v $PWD/files/:/root/.aws --entrypoint /bin/sh -d tonanuvem/kubectl-aws-cli

EXEC="docker exec -ti awscli"

docker exec -ti awscli aws sts get-caller-identity
echo ""

# antes de iniciar, deve ser criada pela console a função "eksFiapClusterRole" e inserir as políticas "AWSElasticBeanstalkWebTier" "AWSElasticBeanstalkMulticontainerDocker" "AWSElasticBeanstalkWorkerTier"
docker exec -ti awscli aws iam create-role --role-name elasticbeanFiapRole --assume-role-policy-document file://elasticbeanRole.json
docker exec -ti awscli aws iam attach-role-policy --policy-arn arn:aws:iam::aws:policy/AWSElasticBeanstalkWebTier --role-name elasticbeanFiapRole
docker exec -ti awscli aws iam attach-role-policy --policy-arn arn:aws:iam::aws:policy/AWSElasticBeanstalkMulticontainerDocker --role-name elasticbeanFiapRole
docker exec -ti awscli aws iam attach-role-policy --policy-arn arn:aws:iam::aws:policy/AWSElasticBeanstalkWorkerTier --role-name elasticbeanFiapRole
docker exec -ti awscli aws iam attach-role-policy --policy-arn arn:aws:iam::aws:policy/AWSElasticBeanstalkEnhancedHealth --role-name elasticbeanFiapRole
docker exec -ti awscli aws iam attach-role-policy --policy-arn arn:aws:iam::aws:policy/AWSElasticBeanstalkManagedUpdatesCustomerRolePolicy --role-name elasticbeanFiapRole

#aws iam get-role --role-name elasticbeanFiapRole

# antes de iniciar, deve ser criada pela console a função "eksFiapWoker" e inserir as políticas "AmazonEKSWorkerNodePolicy, AmazonEKS_CNI_Policy e AmazonEC2ContainerRegistryReadOnly"
#docker exec -ti awscli aws iam create-role --role-name eksFiapWorker --assume-role-policy-document file://eksNodeRole.json
#docker exec -ti awscli aws iam attach-role-policy --policy-arn arn:aws:iam::aws:policy/AmazonEKSWorkerNodePolicy --role-name eksFiapWorker
#docker exec -ti awscli aws iam attach-role-policy --policy-arn arn:aws:iam::aws:policy/AmazonEKS_CNI_Policy --role-name eksFiapWorker
#docker exec -ti awscli aws iam attach-role-policy --policy-arn arn:aws:iam::aws:policy/AmazonEC2ContainerRegistryReadOnly --role-name eksFiapWorker


#docker exec -ti awscli /bin/sh 
docker stop awscli
