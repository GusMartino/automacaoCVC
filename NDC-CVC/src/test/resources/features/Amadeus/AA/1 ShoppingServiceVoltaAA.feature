#language: pt
#encoding: utf-8
#Author: gustavooliveira@ext.cvccorp.com.br

@FlightAvailabilityAmadeus @AMERICANAIRLINES
Funcionalidade: Validação de get em FlightAvailability Ida e Volta
    Eu como usuário quero fazer pesquisa de passagens de Ida e volta e validar informações importantes de retorno da AMERICAN AIRLINES

  @CT01
  Cenário: Get com um adulto MIA/LGA e LGA/MIA nacional
    Dado que o usuário faça uma pesquisa com a opção ida e volta "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&economyClass=YES&packageGroup=GW-CERT&routes=GRU,GIG,2024-01-15, GIG,GRU,2024-02-15"
    Quando valido status code 200
    Então válido em body response aeroporto de ida "MIA"
    E válido em body response aeroporto chegada e volta "LGA"
    E se houver passageiro "ADT" em response seleciono a companhia aérea "AMERICAN AIRLINES" pego token de ida "MIA" "tokenIdaCT01" e volta "LGA" "tokenVoltaCT01"

  
   @CT02 
   Cenário: Get com um adulto e uma criança GRU/LGA e LGA/GRU 
    Dado que o usuário faça uma pesquisa com a opção ida e volta "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,9&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&economyClass=YES&packageGroup=GW-CERT&routes=BPS,CHG,2024-01-15, CHG,BPS,2024-02-12"
    Quando valido status code 200
    Então válido em body response aeroporto de ida "GRU"
    E válido em body response aeroporto chegada e volta "LGA"
    E se houver passageiro "ADT" em response seleciono a companhia aérea "AMERICAN AIRLINES" pego token de ida "GRU" "tokenIdaCT02" e volta "GA" "tokenVoltaCT02"
    E válido em body response passageiro alternativo "CHD"
    
   @CT03 
   Cenário: Get com um adulto e um bebê GIG/LAS e LAS/GIG
    Dado que o usuário faça uma pesquisa com a opção ida e volta "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,1&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&economyClass=YES&packageGroup=GW-CERT&routes=GIG,BPS,2024-01-15, BPS,GIG,2024-02-15"
    Quando valido status code 200
    Então válido em body response aeroporto de ida "GIG"
    E válido em body response aeroporto chegada e volta "LAS"
    E se houver passageiro "ADT" em response seleciono a companhia aérea "AMERICAN AIRLINES" pego token de ida "GIG" "tokenIdaCT03" e volta "LAS" "tokenVoltaCT03"
    E válido em body response passageiro alternativo "INF"

   @CT04
   Cenário: Get com nove adultos GRU/LAS e LAS/GRU
    Dado que o usuário faça uma pesquisa com a opção ida e volta "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,30,30,30,30,30,30,30,30&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&economyClass=YES&packageGroup=GW-CERT&routes=NAT,FOR,2024-01-15, FOR,NAT,2024-02-15"
    Quando valido status code 200
    Então válido em body response aeroporto de ida "GRU"
    E válido em body response aeroporto chegada e volta "LAS"
    E se houver passageiro "ADT" em response seleciono a companhia aérea "AMERICAN AIRLINES" pego token de ida "GRU" "tokenIdaCT04" e volta "LAS" "tokenVoltaCT04"
    E válido em body response quantidade de passageiros no total 9 "ADTS"

    
   @CT05
   Cenário: Get com um adulto e oito crianças LGA/GIG e GIG/LGA
    Dado que o usuário faça uma pesquisa com a opção ida e volta "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,8,8,8,8,8,8,8,8&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&economyClass=YES&packageGroup=GW-CERT&routes=FLN,BPS,2024-01-15, BPS,FLN,2024-02-15"
    Quando valido status code 200
    Então válido em body response aeroporto de ida "LGA"
    E válido em body response aeroporto chegada e volta "GIG"
    E se houver passageiro "ADT" em response seleciono a companhia aérea "AMERICAN AIRLINES" pego token de ida "LGA" "tokenIdaCT05" e volta "GIG" "tokenVoltaCT05"
    E válido em body response quantidade de passageiros alternativos 8 "CHDS"

    
   @CT06
   Cenário: Get com três adultos, três crianças e três bebês MIA/GRU e GRU/MIA
    Dado que o usuário faça uma pesquisa com a opção ida e volta "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30,30,30,1,1,1,9,9,9&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&economyClass=YES&packageGroup=GW-CERT&routes=FLN,GRU,2024-01-15, GRU,FLN,2024-02-15"
    Quando valido status code 200
    Então válido em body response aeroporto de ida "MIA"
    E válido em body response aeroporto chegada e volta "GRU"
    E se houver passageiro "ADT" em response seleciono a companhia aérea "AMERICAN AIRLINES" pego token de ida "MIA" "tokenIdaCT06" e volta "GRU" "tokenVoltaCT06"
    E válido em body response passageiro alternativo "CHD"      
    E válido em body response passageiro alternativo "INF"

    
  @CT07 
  Cenário: Get com um adulto estrangeiro MIA/GIG e GIG/MIA
    Dado que o usuário faça uma pesquisa com a opção ida e volta "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights?ages=30&preferences=persistLog,language:pt_BR,currency:BRL,maxResults:600&source=NLAT&economyClass=YES&packageGroup=GW-CERT&routes=GRU,GIG,2024-01-15, GIG,GRU,2024-02-15"
    Quando valido status code 200
    Então válido em body response aeroporto de ida "MIA"
    E válido em body response aeroporto chegada e volta "GIG"
    E se houver passageiro "ADT" em response seleciono a companhia aérea "AMERICAN AIRLINES" pego token de ida "MIA" "tokenIdaCT07" e volta "GIG" "tokenVoltaCT07"


