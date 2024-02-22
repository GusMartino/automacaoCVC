#language: pt
#encoding: utf-8
#Author: gustavooliveira@ext.cvccorp.com.br

  @InformativePricingInter @Cenário04 
Funcionalidade: Validação de get em InformativePricing Ida
    Eu como usuário quero confirmar preço de voo e validar respota

  @CT08 
  Cenário: Get de confirmação de preço com um adulto MIA/LGA 
    Dado que seleciono rateToken "CT01" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code 200
    Então válido em body response chegada no aeropoto "LGA"
    E guardo rateToken para utilizar em booking "bTokenCT01"
    

  @CT09
   Cenário: Get de confirmação de preço com um adulto e uma criança GRU/MIA
    Dado que seleciono rateToken "CT02" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code 200
    Então válido em body response chegada no aeropoto "MIA"
    E guardo rateToken para utilizar em booking "bTokenCT02"

  @CT10
  Cenário: Get de confirmação de preço com um adulto e um bebê GIG/LAS
    Dado que seleciono rateToken "CT03" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code 200
    Então válido em body response chegada no aeropoto "LAS"
    E guardo rateToken para utilizar em booking "bTokenCT03"
    
  @CT11
  Cenário: Get de confirmação de preço com nove adultos LAS/GRU
    Dado que seleciono rateToken "CT04" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code 200
    Então válido em body response chegada no aeropoto "GRU"
    E guardo rateToken para utilizar em booking "bTokenCT04"
    
  @CT12
  Cenário: Get de confirmação de preço com um adulto e oito crianças GIG/MIA
    Dado que seleciono rateToken "CT05" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code 200
    Então válido em body response chegada no aeropoto "MIA"
    E guardo rateToken para utilizar em booking "bTokenCT05"
    
    
  @CT13
  Cenário: Get de confirmação de preço com três adultos, três crianças e três bebês GRU/BOS
    Dado que seleciono rateToken "CT06" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code 200
    Então válido em body response chegada no aeropoto "BOS"
    E guardo rateToken para utilizar em booking "bTokenCT06"  
						
    	
  @CT14
  Cenário: Get de confirmação de preço com um adulto estrangeiro BOS/GIG
    Dado que seleciono rateToken "CT07" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code 200
    Então válido em body response chegada no aeropoto "GIG"
    E guardo rateToken para utilizar em booking "bTokenCT07"         
    