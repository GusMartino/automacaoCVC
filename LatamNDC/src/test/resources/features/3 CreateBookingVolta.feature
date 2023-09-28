#language: pt
#encoding: utf-8
#Author: gustavooliveira@ext.cvccorp.com.br

@Regressivo @BookingCreate @Cenário02 
Funcionalidade: Validação de post em criação de reserva ida e volta
    Eu como usuário quero criar minha reserva aérea com passagem de ida e volta

@CT01 
Cenário: Post de criação de reserva com um adulto em voo ida e volta SAO/RIO e RIO/SAO
    Dado que eu tenho uma requisição de reserva de voo utilizando o tipo de requisição "1" junto aos tokens "bTokenIdaCT01" e "bTokenVoltaCT01" 
    Quando envio requisição de reserva de voo ida e volta "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings"
    Então válido Status Code 200 junto a bookingToken "bookingTokenVolta01"
    E guardo localizador "reservationCodeVolta01"
    E guardo preço total de reserva "totalOrderPriceVolta01"
    
@CT02 
Cenário: Post de criação de reserva com um adulto e uma crinaça em voo ida e volta SAO/MAD e MAD/SAO
    Dado que eu tenho uma requisição de reserva de voo utilizando o tipo de requisição "2" junto aos tokens "bTokenIdaCT02" e "bTokenVoltaCT02" 
    Quando envio requisição de reserva de voo ida e volta "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings"
    Então válido Status Code 200 junto a bookingToken "bookingTokenVolta02"
    E guardo localizador "reservationCodeVolta02"
    E guardo preço total de reserva "totalOrderPriceVolta02"

@CT03 
Cenário: Post de criação de reserva com um adulto e um bebê em voo ida e volta GIG/BPS e BPS/GIG
    Dado que eu tenho uma requisição de reserva de voo utilizando o tipo de requisição "3" junto aos tokens "bTokenIdaCT03" e "bTokenVoltaCT03" 
    Quando envio requisição de reserva de voo ida e volta "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings"
    Então válido Status Code 200 junto a bookingToken "bookingTokenVolta03"
    E guardo localizador "reservationCodeVolta03"
    E guardo preço total de reserva "totalOrderPriceVolta03"
    
    @CT04 
Cenário: Post de criação de reserva com oito adultos voo ida e volta MAD/SAO e SAO/MAD
    Dado que eu tenho uma requisição de reserva de voo utilizando o tipo de requisição "4" junto aos tokens "bTokenIdaCT04" e "bTokenVoltaCT04" 
    Quando envio requisição de reserva de voo ida e volta "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings"
    Então válido Status Code 200 junto a bookingToken "bookingTokenVolta04"
    E guardo localizador "reservationCodeVolta04"
    E guardo preço total de reserva "totalOrderPriceVolta04"

    @CT05 
Cenário: Post de criação de reserva com um adulto e oito crianças em voo BPS/FLN e FLN/BPS
    Dado que eu tenho uma requisição de reserva de voo utilizando o tipo de requisição "5" junto aos tokens "bTokenIdaCT05" e "bTokenVoltaCT05" 
    Quando envio requisição de reserva de voo ida e volta "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings"
    Então válido Status Code 200 junto a bookingToken "bookingTokenVolta05"
    E guardo localizador "reservationCodeVolta05"
    E guardo preço total de reserva "totalOrderPriceVolta05"
    
    @CT06 
Cenário: Post de criação de reserva com três adultos, três crianças e três bebês em voo FLN/GRU e GRU/FLN
    Dado que eu tenho uma requisição de reserva de voo utilizando o tipo de requisição "6" junto aos tokens "bTokenIdaCT06" e "bTokenVoltaCT06" 
    Quando envio requisição de reserva de voo ida e volta "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings"
    Então válido Status Code 200 junto a bookingToken "bookingTokenVolta06"
    E guardo localizador "reservationCodeVolta06"
    E guardo preço total de reserva "totalOrderPriceVolta06"   
    
    @CT07 
Cenário: Post de criação de reserva com um adulto estrangeiro em voo DXB/GRU e GRU/DXB
    Dado que eu tenho uma requisição de reserva de voo utilizando o tipo de requisição "7" junto aos tokens "bTokenIdaCT07" e "bTokenVoltaCT07" 
    Quando envio requisição de reserva de voo ida e volta "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/bookings"
    Então válido Status Code 200 junto a bookingToken "bookingTokenVolta07"
    E guardo localizador "reservationCodeVolta07"
    E guardo preço total de reserva "totalOrderPriceVolta07"      
