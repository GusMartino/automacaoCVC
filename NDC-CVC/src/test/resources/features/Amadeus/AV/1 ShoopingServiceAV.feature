
#language: pt
#encoding: utf-8
#Author: gustavooliveira@ext.cvccorp.com.br

@FlightAvailabilityAmadeus @AVIANCA @Cenário04
Funcionalidade: Validação de get em FlightAvailability visando companhia AVIANCA
    Eu como usuário quero fazer pesquisa de passagens da companhia AVIANCA e validar retorno

  @CT08
  Cenário: Get com um adulto BOG/MDE nacional
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30&preferences=persistLog%2Clanguage%3Apt_BR%2Ccurrency%3ABRL%2CmaxResults%3A600&source=NAMD&routes=BOG,MDE,2024-02-12&packageGroup=GW-CERT&businessClass=ALSO&airCompanies=AV"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "BOG"
    E válido em body response aeroporto chegada "MDE"
    E guardo o rateToken "CT01" da companhia aérea esperada "AVIANCA"

  
   @CT09
   Cenário: Get com um adulto e uma criança GRU/BOG
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,8&preferences=persistLog%2Clanguage%3Apt_BR%2Ccurrency%3ABRL%2CmaxResults%3A600&source=NAMD&routes=GRU,BOG,2024-02-12&packageGroup=GW-CERT&businessClass=ALSO&airCompanies=AV"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "GRU"
    E válido em body response aeroporto chegada "BOG"
    E válido em body response passageiro "CHD"
    E guardo o rateToken "CT02" da companhia aérea esperada "AVIANCA"

    
   @CT10
   Cenário: Get com um adulto e um bebê GIG/BOG
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,0&preferences=persistLog%2Clanguage%3Apt_BR%2Ccurrency%3ABRL%2CmaxResults%3A600&source=NAMD&routes=GIG,BOG,2024-02-12&packageGroup=GW-CERT&businessClass=ALSO&airCompanies=AV"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "GIG"
    E válido em body response aeroporto chegada "BOG"
    E válido em body response passageiro "INF"
    E guardo o rateToken "CT03" da companhia aérea esperada "AVIANCA"


   @C11
   Cenário: Get com nove adultos GRU/MDE
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,30,30,30,30,30,30,30,30&preferences=persistLog%2Clanguage%3Apt_BR%2Ccurrency%3ABRL%2CmaxResults%3A600&source=NAMD&routes=GRU,MDE,2024-02-12&packageGroup=GW-CERT&businessClass=ALSO&airCompanies=AV"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "GRU"
    E válido em body response aeroporto chegada "MDE"
    E válido em body response quantidade de passageiros 9 "ADTS"
    E guardo o rateToken "CT04" da companhia aérea esperada "AVIANCA"
    
   @CT12 
   Cenário: Get com um adulto e oito crianças MDE/GIG
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,9,9,9,9,9,9,9,9&preferences=persistLog%2Clanguage%3Apt_BR%2Ccurrency%3ABRL%2CmaxResults%3A600&source=NAMD&routes=MDE,GIG,2024-02-12&packageGroup=GW-CERT&businessClass=ALSO&airCompanies=AV"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "MDE"
    E válido em body response aeroporto chegada "GIG"
    E válido em body response passageiro "CHD"
    E válido em body response quantidade de passageiros 8 "CHDS"
    E guardo o rateToken "CT05" da companhia aérea esperada "AVIANCA"  
    
   @CT13
   Cenário: Get com três adultos, três crianças e três bebês GRU/MAD
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,30,30,9,9,9,0,0,0&preferences=persistLog%2Clanguage%3Apt_BR%2Ccurrency%3ABRL%2CmaxResults%3A600&source=NAMD&routes=GRU,MAD,2024-02-12&packageGroup=GW-CERT&businessClass=ALSO&airCompanies=AV"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "GRU"
    E válido em body response aeroporto chegada "MAD"
    E válido em body response passageiro "CHD"      
    E válido em body response passageiro "INF"
    E válido em body response quantidade de passageiros 3 "De cada"   
    E guardo o rateToken "CT06" da companhia aérea esperada "AVIANCA"   
    
    @CT14
    Cenário: Get com um adulto estrangeiro BOG/GRU
    Dado que o usuário faça uma pesquisa com a opção só ida "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30&preferences=persistLog%2Clanguage%3Apt_BR%2Ccurrency%3ABRL%2CmaxResults%3A600&source=NAMD&routes=BOG,GRU,2024-02-12&packageGroup=GW-CERT&businessClass=ALSO&airCompanies=AV"
    Quando valido status code de response 200
    Então válido em body response aeroporto saída "BOG"
    E válido em body response aeroporto chegada "GRU"
    E guardo o rateToken "CT07" da companhia aérea esperada "AVIANCA"