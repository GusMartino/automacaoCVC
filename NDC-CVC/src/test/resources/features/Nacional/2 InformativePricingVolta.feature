#language: pt
#encoding: utf-8
#Author: gustavooliveira@ext.cvccorp.com.br

@Regressivo @InformativePricing @Cenário02 @BookingCreate @BookingIssue @CancellVoid
Funcionalidade: Validação de get em InformativePricing Ida e Volta 
    Eu como usuário quero confirmar preço de voo e validar respota

  @CT01
  Cenário: Get de confirmação de preço com um adulto ida e volta SAO/RIO e RIO/SAO
    Dado que seleciono rateToken de ida "tokenIdaCT01" junto a token de volta "tokenVoltaCT01" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code em response 200
    Então válido em body response chegada na ida no aeropoto "GIG"
    E guardo rateToken de ida "GRU" "bTokenIdaCT01" e volta "GIG" "bTokenVoltaCT01" para utilizar em booking 
    
  @CT02 @tEST
  Cenário: Get de confirmação de preço com um adulto e uma criança BSB/SAO e SAO/BSB
    Dado que seleciono rateToken de ida "tokenIdaCT02" junto a token de volta "tokenVoltaCT02" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code em response 200
    Então válido em body response chegada na ida no aeropoto "CGH"
    E guardo rateToken de ida "BSB" "bTokenIdaCT02" e volta "CGH" "bTokenVoltaCT02" para utilizar em booking     
    
  @CT03
  Cenário: Get de confirmação de preço com um adulto e um bebê GIG/BPS e BPS/GIG
    Dado que seleciono rateToken de ida "tokenIdaCT03" junto a token de volta "tokenVoltaCT03" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code em response 200
    Então válido em body response chegada na ida no aeropoto "BPS"
    E guardo rateToken de ida "GIG" "bTokenIdaCT03" e volta "BPS" "bTokenVoltaCT03" para utilizar em booking    
    
  @CT04
  Cenário: Get de confirmação de preço com nove adultos NAT/FOR e FOR/NAT
    Dado que seleciono rateToken de ida "tokenIdaCT04" junto a token de volta "tokenVoltaCT04" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code em response 200
    Então válido em body response chegada na ida no aeropoto "FOR"
    E guardo rateToken de ida "NAT" "bTokenIdaCT04" e volta "FOR" "bTokenVoltaCT04" para utilizar em booking        
    
  @CT05
  Cenário: Get de confirmação de preço com um adulto e oito crianças BPS/FLN e FLN/BPS
    Dado que seleciono rateToken de ida "tokenIdaCT05" junto a token de volta "tokenVoltaCT05" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code em response 200
    Então válido em body response chegada na ida no aeropoto "FLN"
    E guardo rateToken de ida "BPS" "bTokenIdaCT05" e volta "FLN" "bTokenVoltaCT05" para utilizar em booking          
    
  @CT06
  Cenário: Get de confirmação de preço com três adultos, três crianças e três bebês FLN/GRU e GRU/FLN
    Dado que seleciono rateToken de ida "tokenIdaCT06" junto a token de volta "tokenVoltaCT06" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code em response 200
    Então válido em body response chegada na ida no aeropoto "GRU"
    E guardo rateToken de ida "FLN" "bTokenIdaCT06" e volta "GRU" "bTokenVoltaCT06" para utilizar em booking  
    
  @CT07
  Cenário: Get de confirmação de preço com um adulto estrangeiro GRU/GIG e GIG/GRU
    Dado que seleciono rateToken de ida "tokenIdaCT07" junto a token de volta "tokenVoltaCT07" e inicio chamada em API "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/rateTokens?preferences=persistLog,language:pt_BR,currency:BRL"
    Quando válido status code em response 200
    Então válido em body response chegada na ida no aeropoto "GIG"
    E guardo rateToken de ida "GRU" "bTokenIdaCT07" e volta "GIG" "bTokenVoltaCT07" para utilizar em booking              