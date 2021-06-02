cd ~
rm -rf pagamento && rm -rf pagamento-bdd
git clone https://github.com/tonanuvem/pagamento.git
git clone https://github.com/tonanuvem/pagamento-bdd.git
cd pagamento && sh aws_codebuild/codecommit.sh 
cd aws_codebuild && sh elasticbean.sh && cd ..
