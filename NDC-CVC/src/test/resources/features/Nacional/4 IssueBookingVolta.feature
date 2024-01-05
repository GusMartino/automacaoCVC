#language: pt
#encoding: utf-8
#Author: gustavooliveira@ext.cvccorp.com.br

@Regressivo @BookingIssue @Cenário02 @CancellVoid
Funcionalidade: Validação de post para emissão de reserva de voos ida e volta
    Eu como usuário quero criar minha reserva aérea para voos de ida e volta
    
   @CT01
    Cenário: Post de emissão de reserva aerea ida e volta com um adulto em voo ida e volta SAO/RIO e RIO/SAO  
    Dado que eu tenho uma requisição de emissão doo voo ida e volta com o token de reserva "bookingTokenVolta01" junto a valor de emissão "totalOrderPriceVolta01"
    Quando seleciono tipo de pagamento válido "Cash"
    E envio requisição de emissão para o voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete do voo "ISSUED"
    E válido tipo de pagamento "INVOICE" junto ao provedor encontrado "NLAT"        

    @CT02 
    Cenário: Post de emissão de reserva aerea ida e volta com um adulto e uma criança em voo ida e volta SAO/MAD e MAD/SAO  
    Dado que eu tenho uma requisição de emissão doo voo ida e volta com o token de reserva "bookingTokenVolta02" junto a valor de emissão "totalOrderPriceVolta02"
    Quando seleciono tipo de pagamento válido "Cartao"
    E envio requisição de emissão para o voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete do voo "ISSUED"
    E válido tipo de pagamento "CREDITCARD" junto ao provedor encontrado "NLAT"     

    @CT03 
    Cenário: Post de emissão de reserva aerea ida e volta com um adulto e um bebê em voo ida e volta GIG/BPS e BPS/GIG  
    Dado que eu tenho uma requisição de emissão doo voo ida e volta com o token de reserva "bookingTokenVolta03" junto a valor de emissão "totalOrderPriceVolta03"
    Quando seleciono tipo de pagamento válido "Cash"
    E envio requisição de emissão para o voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete do voo "ISSUED"
    E válido tipo de pagamento "INVOICE" junto ao provedor encontrado "NLAT"        

    @CT04 
    Cenário: Post de emissão de reserva aerea ida e volta com nove adultos em voo ida e volta MAD/SAO e SAO/MAD  
    Dado que eu tenho uma requisição de emissão doo voo ida e volta com o token de reserva "bookingTokenVolta04" junto a valor de emissão "totalOrderPriceVolta04"
    Quando seleciono tipo de pagamento válido "Cartao"
    E envio requisição de emissão para o voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete do voo "ISSUED"
    E válido tipo de pagamento "CREDITCARD" junto ao provedor encontrado "NLAT"        

    @CT05 
    Cenário: Post de emissão de reserva aerea ida e volta com um adulto e oito crianças em voo ida e volta BPS/FLN e FLN/BPS  
    Dado que eu tenho uma requisição de emissão doo voo ida e volta com o token de reserva "bookingTokenVolta05" junto a valor de emissão "totalOrderPriceVolta05"
    Quando seleciono tipo de pagamento válido "Cash"
    E envio requisição de emissão para o voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete do voo "ISSUED"
    E válido tipo de pagamento "INVOICE" junto ao provedor encontrado "NLAT"      

    @CT06 
    Cenário: Post de emissão de reserva aerea ida e volta com três adultos, três crianças e três bebÊs em voo ida e volta FLN/GRU e GRU/FLN  
    Dado que eu tenho uma requisição de emissão doo voo ida e volta com o token de reserva "bookingTokenVolta06" junto a valor de emissão "totalOrderPriceVolta06"
    Quando seleciono tipo de pagamento válido "Cartao"
    E envio requisição de emissão para o voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete do voo "ISSUED"
    E válido tipo de pagamento "CREDITCARD" junto ao provedor encontrado "NLAT"      

    @CT07 
    Cenário: Post de emissão de reserva aerea ida e volta com um adulto estrangeiro em voo ida e volta DXB/GRU e GRU/DXB  
    Dado que eu tenho uma requisição de emissão doo voo ida e volta com o token de reserva "bookingTokenVolta07" junto a valor de emissão "totalOrderPriceVolta07"
    Quando seleciono tipo de pagamento válido "Cash"
    E envio requisição de emissão para o voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete do voo "ISSUED"
    E válido tipo de pagamento "INVOICE" junto ao provedor encontrado "NLAT"     