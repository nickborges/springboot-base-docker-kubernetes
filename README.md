#-------------------------------------------------------------------
#                      ETRUTURA DE DADOS 
#-------------------------------------------------------------------    
    base de dados: mongodb
    nome do banco: meubanco
    tabela: veiculos
    script database:
        -> via linha de comando entrar no diretório do mongo e escutar o seguinte comando:
            mongorestore --drop --db your_database_name C://caminhoOndeEstaOscriptDoBanco/yourPath/
    

#-------------------------------------------------------------------
#                        ESTRUTURA DO PROJETO
#-------------------------------------------------------------------

    Java/Springboot

    CONTROLLER
        --> FUNCIONALIDADE_1 (SERVICE)
            --> BEANS
            --> ENTITY
            --> REPOSITORY
            --> SERVICE_1

        --> FUNCIONALIDADE_2 (SERVICE)
            --> BEANS
            --> ENTITY
            --> REPOSITORY
            --> SERVICE_2

        --> FUNCIONALIDADE_3 (SERVICE)
            --> BEANS
            --> ENTITY
            --> REPOSITORY
            --> SERVICE_3

        --> FUNCIONALIDADE_4 (SERVICE)
            --> BEANS
            --> ENTITY
            --> REPOSITORY
            --> SERVICE_4

         ....

#-------------------------------------------------------------------
#                      DOCKER - KUBERNETES
#-------------------------------------------------------------------

    /docker

        1. gradle clean build
        2. buildar a imagens:       docker-compose build
        3. logar no docker hub:     docker login
        4. tag para commit:         docker tag number_image_id nickkborges/springboot-docker-kubernetes:v1
        5. push no docker hub:      docker push nickkborges/springboot-docker-kubernetes

    /kubernetes

        LOCAL:
            1. criar o deployment:      sudo kubectl create -f api-deployment.yaml
            2. criar o servico:         sudo kubectl create -f servico-deployment.yaml
            3. obter a url:             sudo minikube service service-api-springboot-docker-kubernetes --url
        
        GCLOUD:
            1. crair o cluster:     http://cloud.google.com
            2. login no gcloud:     gcloud auth login
            3. conectar no cluster: gcloud container clusters get-credentials springboot-base-docker-kubernetes --zone southamerica-east1-a --project springboot-docker-kubernetes
            4. criar o deployment:  kubectl create -f api-deployment.yaml
            5. criar o servico:     kubectl create -f servico-deployment.yaml
            6. obeter o IP externo: kubectl get services
            7. acessar api:         http://35.198.8.64:8080/api/teste
            




