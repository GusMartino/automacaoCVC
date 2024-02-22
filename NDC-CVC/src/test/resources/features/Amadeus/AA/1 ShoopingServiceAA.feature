
#language: pt
#encoding: utf-8
#Author: gustAAooliveira@ext.cvccorp.com.br

@FlightAvailabilityAmadeus @AMERICANAIRLINES @Cenário04
Funcionalidade: Validação de get em FlightAAailability visando companhia AMERICAN AIRLINES
    Eu como usuário quero fazer pesquisa de passagens da companhia AMERICAN AIRLINES e validar retorno

  @CT08
  Cenário: Get com um adulto MIA/LGA nacional
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30&preferences=persistLog%2Clanguage%3Apt_BR%2Ccurrency%3ABRL%2CmaxResults%3A600&source=NAMD&routes=MIA,LGA,2024-02-12&packageGroup=GW-CERT&businessClass=ALSO&airCompanies=AA"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "MIA"
    E válido em body response aeroporto chegada "LGA"
    E guardo o rateToken "CT01" da companhia aérea esperada "AMERICAN AIRLINES"

  
   @CT09
   Cenário: Get com um adulto e uma criança GRU/MIA
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,8&preferences=persistLog%2Clanguage%3Apt_BR%2Ccurrency%3ABRL%2CmaxResults%3A600&source=NAMD&routes=GRU,MIA,2024-02-12&packageGroup=GW-CERT&businessClass=ALSO&airCompanies=AA"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "GRU"
    E válido em body response aeroporto chegada "MIA"
    E válido em body response passageiro "CHD"
    E guardo o rateToken "CT02" da companhia aérea esperada "AMERICAN AIRLINES"

    
   @CT10
   Cenário: Get com um adulto e um bebê GIG/LAS
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,0&preferences=persistLog%2Clanguage%3Apt_BR%2Ccurrency%3ABRL%2CmaxResults%3A600&source=NAMD&routes=GIG,LAS,2024-02-12&packageGroup=GW-CERT&businessClass=ALSO&airCompanies=AA"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "GIG"
    E válido em body response aeroporto chegada "LAS"
    E válido em body response passageiro "INF"
    E guardo o rateToken "CT03" da companhia aérea esperada "AMERICAN AIRLINES"


   @C11
   Cenário: Get com nove adultos LAS/GRU
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,30,30,30,30,30,30,30,30&preferences=persistLog%2Clanguage%3Apt_BR%2Ccurrency%3ABRL%2CmaxResults%3A600&source=NAMD&routes=LAS,GRU,2024-02-12&packageGroup=GW-CERT&businessClass=ALSO&airCompanies=AA"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "LAS"
    E válido em body response aeroporto chegada "GRU"
    E válido em body response quantidade de passageiros 9 "ADTS"
    E guardo o rateToken "CT04" da companhia aérea esperada "AMERICAN AIRLINES"
    
   @CT12 
   Cenário: Get com um adulto e oito crianças GIG/MIA
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,9,9,9,9,9,9,9,9&preferences=persistLog%2Clanguage%3Apt_BR%2Ccurrency%3ABRL%2CmaxResults%3A600&source=NAMD&routes=GIG,MIA,2024-02-12&packageGroup=GW-CERT&businessClass=ALSO&airCompanies=AA"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "GIG"
    E válido em body response aeroporto chegada "MIA"
    E válido em body response passageiro "CHD"
    E válido em body response quantidade de passageiros 8 "CHDS"
    E guardo o rateToken "CT05" da companhia aérea esperada "AMERICAN AIRLINES"  
    
   @CT13
   Cenário: Get com três adultos, três crianças e três bebês GRU/BOS
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,30,30,9,9,9,0,0,0&preferences=persistLog%2Clanguage%3Apt_BR%2Ccurrency%3ABRL%2CmaxResults%3A600&source=NAMD&routes=GRU,BOS,2024-02-12&packageGroup=GW-CERT&businessClass=ALSO&airCompanies=AA"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "GRU"
    E válido em body response aeroporto chegada "BOS"
    E válido em body response passageiro "CHD"      
    E válido em body response passageiro "INF"
    E válido em body response quantidade de passageiros 3 "De cada"   
    E guardo o rateToken "CT06" da companhia aérea esperada "AMERICAN AIRLINES"   
    
    @CT14
    Cenário: Get com um adulto estrangeiro BOS/GIG
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30&preferences=persistLog%2Clanguage%3Apt_BR%2Ccurrency%3ABRL%2CmaxResults%3A600&source=NAMD&routes=BOS,GIG,2024-02-12&packageGroup=GW-CERT&businessClass=ALSO&airCompanies=AA"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "BOS"
    E válido em body response aeroporto chegada "GIG"
    E guardo o rateToken "CT07" da companhia aérea esperada "AMERICAN AIRLINES"