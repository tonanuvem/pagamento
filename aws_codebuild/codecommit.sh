echo "Iniciando repositorio do Projeto Pagamento SpringRest:"
cd ~/environment/pagamento
rm -rf .git
echo -e '*/target/**' >> .gitignore
git init
git add *
git add .mvn/*
git commit -m "Publicando app no Beanstalk"
