#language: pt
#encoding: utf-8
#Author: gustavooliveira@ext.cvccorp.com.br

@Regressivo @InformativePricing @Cenário01
Funcionalidade: Validação de get em InformativePricing Ida
    Eu como usuário quero confirmar preço de voo e validar respota

  @CT01 @Teste
  Cenário: Get de confirmação de preço com um adulto SAO/RIO 
    Dado seleciono rateToken "CT01" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code 200
    Então válido em body response chegada no aeropoto "GIG"
    E guardo rateToken para utilizar em booking "CT01"

  @CT02 
   Cenário: Get de confirmação de preço com um adulto e uma criança SAO/MAD
    Dado seleciono rateToken "CT02" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code 200
    Então válido em body response chegada no aeropoto "MAD"
    E guardo rateToken para utilizar em booking "CT02"

  @CT03
  Cenário: Get de confirmação de preço com um adulto e um bebê GIG/BPS
    Dado seleciono rateToken "CT03" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code 200
    Então válido em body response chegada no aeropoto "BPS"
    E guardo rateToken para utilizar em booking "CT03"
    
  @CT04
  Cenário: Get de confirmação de preço com nove adultos MAD/SAO
    Dado seleciono rateToken "CT04" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code 200
    Então válido em body response chegada no aeropoto "GRU"
    E guardo rateToken para utilizar em booking "CT04"
    
  @CT05
  Cenário: Get de confirmação de preço com um adulto e oito crianças BPS/FLN
    Dado seleciono rateToken "CT05" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code 200
    Então válido em body response chegada no aeropoto "FLN"
    E guardo rateToken para utilizar em booking "CT05"
    
  @CT06
  Cenário: Get de confirmação de preço com três adultos, três crianças e três bebês FLN/GRU
    Dado seleciono rateToken "CT06" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code 200
    Então válido em body response chegada no aeropoto "GRU"
    E guardo rateToken para utilizar em booking "CT06"            