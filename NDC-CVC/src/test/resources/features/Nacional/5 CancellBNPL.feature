#language: pt
#encoding: utf-8
#Author: gustavooliveira@ext.cvccorp.com.br

@Regressivo @CancellBNPL 
Funcionalidade: Delete em requisição para cancelar reserva dos voos de ida
    Eu como usuário quero cancelar minha reserva aérea antes da emissão

    @CT01
    Cenário: Del em reserva com um adulto em voo ida SAO/RIO 
    Dado que eu utilize o "bookingToken01" para cancelar minha reserva
    Quando envio requisição para a url "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/"
    Então válido Status Code 200 para confirmar sucesso em cancelamento

    @CT02 
    Cenário: Del em reserva com um adulto e uma criança em voo ida SAO/MAD 
    Dado que eu utilize o "bookingToken02" para cancelar minha reserva
    Quando envio requisição para a url "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/"
    Então válido Status Code 200 para confirmar sucesso em cancelamento    
     
    @CT03 
    Cenário: Del em reserva com um adulto e um bebê em voo ida GIG/BPS 
    Dado que eu utilize o "bookingToken03" para cancelar minha reserva
    Quando envio requisição para a url "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/"
    Então válido Status Code 200 para confirmar sucesso em cancelamento   

    @CT04 
    Cenário: Del em reserva com nove adultos em voo ida MAD/SAO
    Dado que eu utilize o "bookingToken04" para cancelar minha reserva
    Quando envio requisição para a url "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/"
    Então válido Status Code 200 para confirmar sucesso em cancelamento       

    @CT05 
    Cenário: Del em reserva com um adulto e oito crianças em voo ida BPS/FLN  
    Dado que eu utilize o "bookingToken05" para cancelar minha reserva
    Quando envio requisição para a url "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/"
    Então válido Status Code 200 para confirmar sucesso em cancelamento    

    @CT06 
    Cenário: Del em reserva com três adultos, três crianças e três bebÊs em voo ida FLN/GRU  
    Dado que eu utilize o "bookingToken06" para cancelar minha reserva
    Quando envio requisição para a url "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/"
    Então válido Status Code 200 para confirmar sucesso em cancelamento    

    @CT07 
    Cenário: Del em reserva com um adulto estrangeiro em voo ida DXB/GRU 
    Dado que eu utilize o "bookingToken07" para cancelar minha reserva
    Quando envio requisição para a url "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings/"
    Então válido Status Code 200 para confirmar sucesso em cancelamento       
            