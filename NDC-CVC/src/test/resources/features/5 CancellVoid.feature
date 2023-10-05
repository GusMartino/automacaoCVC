#language: pt
#encoding: utf-8
#Author: gustavooliveira@ext.cvccorp.com.br

@Regressivo @CancellVoid @Cenário02 
Funcionalidade: Delete em requisição para cancelar bilhete emitido dos voos de ida e volta
    Eu como usuário quero cancelar meu bilhete emitido

    @CT01
    Cenário: Del em bilhete emitido com um adulto em voo ida SAO/RIO 
    Dado que utilize o "bookingTokenVolta01" para cancelar minha reserva
    Quando envio requisição para "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/"
    Então válido Status Code 200 para confirmar cancelamento com sucesso

    @CT02 
    Cenário: Del em bilhete emitido com um adulto e uma criança em voo ida SAO/MAD 
    Dado que utilize o "bookingTokenVolta02" para cancelar minha reserva
    Quando envio requisição para "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/"
    Então válido Status Code 200 para confirmar cancelamento com sucesso    
     
    @CT03 
    Cenário: Del em bilhete emitido com um adulto e um bebê em voo ida GIG/BPS 
    Dado que utilize o "bookingTokenVolta03" para cancelar minha reserva
    Quando envio requisição para "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/"
    Então válido Status Code 200 para confirmar cancelamento com sucesso   

    @CT04 
    Cenário: Del em bilhete emitido com nove adultos em voo ida MAD/SAO
    Dado que utilize o "bookingTokenVolta04" para cancelar minha reserva
    Quando envio requisição para "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/"
    Então válido Status Code 200 para confirmar cancelamento com sucesso       

    @CT05 
    Cenário: Del em bilhete emitido com um adulto e oito crianças em voo ida BPS/FLN  
    Dado que utilize o "bookingTokenVolta05" para cancelar minha reserva
    Quando envio requisição para "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/"
    Então válido Status Code 200 para confirmar cancelamento com sucesso    

    @CT06 
    Cenário: Del em bilhete emitido com três adultos, três crianças e três bebÊs em voo ida FLN/GRU  
    Dado que utilize o "bookingTokenVolta06" para cancelar minha reserva
    Quando envio requisição para "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/"
    Então válido Status Code 200 para confirmar cancelamento com sucesso    

    @CT07 
    Cenário: Del em bilhete emitido com um adulto estrangeiro em voo ida DXB/GRU 
    Dado que utilize o "bookingTokenVolta07" para cancelar minha reserva
    Quando envio requisição para "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/"
    Então válido Status Code 200 para confirmar cancelamento com sucesso       
            