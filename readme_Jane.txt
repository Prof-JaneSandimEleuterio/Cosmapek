

****************************************************** 
********************* Sobre o DB ********************* 
****************************************************** 
Para executar os serviços implementados em REST
****************************************************** 

- Sempre usar a versao 2.1.0, pois a mais nova não funciona



- o script "startConsole.bat"faz:
--- apaga os BDs // sempre devem ser apagados antes de startar
--- inicia o bdoriented (bin/server.bat)
--- inicia cada um dos serviços

OBS: se iniciar algo errado, tem que reiniciar o PC




- caso tenha que derrubar um serviço em execução, somente pode apagar o BD pelo site
---login e senha no código
------ root e cupecupe

- para acessar ao bd: http://localhost:2480/

--- para retomar o serviço, rodar o script correspondente, por exemplo "a.bat"


Links para testes
http://localhost:1723/v1/companies/1000/products/
http://localhost:1723/v1/companies/1000/operationHour/
http://localhost:1723/v1/companies?longitude=-10&latitude=-20&num=20

http://192.168.0.104:3389/v1/companies/"+companyId+"/operationHour/
"http://192.168.0.104:9418/v1/companies?longitude&latitude&num")





****************************************************** 
*************** Preparar Android Studio ************** 
****************************************************** 
Para preparar o ambinete de programação para android
****************************************************** 

- instalar o android studio completo
- instalar os SDKs 21 e 22:
-- Tools - Android - SDK manager

- Configurar o buildToolsVersion:
-- Na visão de projeto, abrir o arquivo "app/build.gradle"
-- editar para buildToolsVersion "23.0.2"
--- obs: caso não funcione, crie um novo projeto no Android Studio e copie o valor gerado para "buildToolsVersion"






****************************************************** 
**************** Sobre o BuscameB_v2 ***************** 
****************************************************** 
Prepara aplicação Buscame para utilizar as novas urls
****************************************************** 

-Não esquecer de trocar o IP para cada serviço/componente/servidor
---> essa linha de codigo define em qual servidor conecta

- No Android Studio, 
--- app/src/main/java/unicamp.buscame/configuration/core/ConfigurationM.java
----- atualizar o ip do ClienteResorce

--- fazer isso para todos:
----- app/src/main/java/unicamp.buscame/configuration/core/ConfigurationM.java
----- app/src/main/java/unicamp.buscame/configurationB/core/ConfigurationM.java

----- app/src/main/java/unicamp.buscame/localization/core/LocalizationM.java
----- app/src/main/java/unicamp.buscame/localizationB/core/LocalizationM.java
----- app/src/main/java/unicamp.buscame/localizationC/core/LocalizationM.java

----- app/src/main/java/unicamp.buscame/product/core/ProductM.java
----- app/src/main/java/unicamp.buscame/productB/core/ProductM.java
----- app/src/main/java/unicamp.buscame/productC/core/ProductM.java








****************************************************** 
*********** Preparar dispositivo Android ************* 
****************************************************** 
Configura um celuar android para rodar o Buscame
****************************************************** 

-- no celular, colocar na pasta "sdcard" os arquivos xml
----config.xml
----variability.xml
------> eles estão na pasta C:\COSMAPEK\MapekCosmos\resources

-sugestão: usar o "Android Device Monitor" 
--- no Android Studio - Tools - Android Device Monitor
--- escolher o dispositivo 
--- no file explorer, localizar a pasta "sdcard"
--- opção "push a file onto the device" (icone com seta e celular)



