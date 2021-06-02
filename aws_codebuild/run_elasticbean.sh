#!/bin/bash
cd ~/environment
DIR="$PWD/pagamento"
#if [ -d "$DIR" ]; then
  rm -rf pagamento
#fi
DIRBDD="$PWD/pagamento-bdd"
#if [ -d "$DIR" ]; then
  rm -rf pagamento-bdd
#fi
git clone https://github.com/tonanuvem/pagamento.git
git clone https://github.com/tonanuvem/pagamento-bdd.git
cd pagamento/aws_codebuild
sh codecommit.sh
echo "" & echo ""
sh config_credenciais.sh
sh elasticbean_role.sh

cd ~/environment/pagamento

echo "Digite seu Primeiro Nome:" && read NOME
echo "Digite seu Ultimo Sobrenome:" && read SOBRENOME

aws elasticbeanstalk check-dns-availability --cname-prefix $NOME$SOBRENOME

# configurando elasticbeanstalk
eb init
eb create pagamento-env -c $NOME$SOBRENOME
