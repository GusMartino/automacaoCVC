#language: pt
#encoding: utf-8
#Author: gustavooliveira@ext.cvccorp.com.br

  @InformativePricingInter @Cenário04
Funcionalidade: Validação de get em InformativePricing Ida
    Eu como usuário quero confirmar preço de voo e validar respota

  @CT01 
  Cenário: Get de confirmação de preço com um adulto SAO/MIA 
    Dado que seleciono rateToken "CT01" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code 200
    Então válido em body response chegada no aeropoto "MIA"
    E guardo rateToken para utilizar em booking "bTokenCT01"
    

  @CT02 
   Cenário: Get de confirmação de preço com um adulto e uma criança GIG/BCN
    Dado que seleciono rateToken "CT02" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code 200
    Então válido em body response chegada no aeropoto "BCN"
    E guardo rateToken para utilizar em booking "bTokenCT02"

  @CT03 
  Cenário: Get de confirmação de preço com um adulto e um bebê GIG/MAD
    Dado que seleciono rateToken "CT03" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code 200
    Então válido em body response chegada no aeropoto "MAD"
    E guardo rateToken para utilizar em booking "bTokenCT03"
    
  @CT04 @Test
  Cenário: Get de confirmação de preço com nove adultos GRU/LAX
    Dado que seleciono rateToken "CT04" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code 200
    Então válido em body response chegada no aeropoto "LAX"
    E guardo rateToken para utilizar em booking "bTokenCT04"
    
  @CT05 @Test
  Cenário: Get de confirmação de preço com um adulto e oito crianças MAD/MIA
    Dado que seleciono rateToken "CT05" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code 200
    Então válido em body response chegada no aeropoto "MIA"
    E guardo rateToken para utilizar em booking "bTokenCT05"
    
    
  @CT06 
  Cenário: Get de confirmação de preço com três adultos, três crianças e três bebês MIA/BOG
    Dado que seleciono rateToken "CT06" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code 200
    Então válido em body response chegada no aeropoto "BOG"
    E guardo rateToken para utilizar em booking "bTokenCT06"  

    
  @CT07 
  Cenário: Get de confirmação de preço com um adulto estrangeiro BOG/GRU
    Dado que seleciono rateToken "CT07" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code 200
    Então válido em body response chegada no aeropoto "GRU"
    E guardo rateToken para utilizar em booking "bTokenCT07"         