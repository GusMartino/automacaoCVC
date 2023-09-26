#language: pt
#encoding: utf-8
#Author: gustavooliveira@ext.cvccorp.com.br

@Regressivo @BookingIssue @Cenário01 
Funcionalidade: Validação de post em emissão de reserva
    Eu como usuário quero criar minha reserva aérea

    @CT01 @Teste @Ida
    Cenário: Post de emissão de reserva com um adulto em voo SAO/RIO 
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "reservationCode01" junto a valor de emissão "totalOrderPrice01"
    Quando seleciono tipo de pagamento "Cartao"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "CREDITCARD" junto ao provedor "NLAT"
    
    @CT02 @Ida
    Cenário: Post de emissão de reserva com um adulto e uma criança em voo SAO/MAD 
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "reservationCode02" junto a valor de emissão "totalOrderPrice02"
    Quando seleciono tipo de pagamento "Cash"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "INVOICE" junto ao provedor "NLAT"    
    
    @CT03 @Ida
    Cenário: Post de emissão de reserva com um adulto e um bebÊ em voo GIG/BPS 
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "reservationCode03" junto a valor de emissão "totalOrderPrice03"
    Quando seleciono tipo de pagamento "Cartao"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "CREDITCARD" junto ao provedor "NLAT"        
    
    @CT04 @Ida
    Cenário: Post de emissão de reserva com nove adultos em voo MAD/SAO 
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "reservationCode04" junto a valor de emissão "totalOrderPrice04"
    Quando seleciono tipo de pagamento "Cash"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "INVOICE" junto ao provedor "NLAT" 
    
    @CT05 @Ida
    Cenário: Post de emissão de reserva com um adulto e oito crianças em voo BPS/FLN
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "reservationCode05" junto a valor de emissão "totalOrderPrice05"
    Quando seleciono tipo de pagamento "Cartao"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "CREDITCARD" junto ao provedor "NLAT"        
 
    @CT06 @Ida
    Cenário: Post de emissão de reserva com três adultos, três crianças e três bebês em voo FLN/GRU
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "reservationCode06" junto a valor de emissão "totalOrderPrice06"
    Quando seleciono tipo de pagamento "Cash"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "INVOICE" junto ao provedor "NLAT" 
   
    @CT07 @Ida
    Cenário: Post de emissão de emissão com um adulto estrangeiro em voo DXB/GRU
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "reservationCode07" junto a valor de emissão "totalOrderPrice07"
    Quando seleciono tipo de pagamento "Cartao"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "CREDITCARD" junto ao provedor "NLAT"        

    @CT01 @IdaEVolta
    Cenário: Post de emissão de reserva aerea ida e volta com um adulto em voo SAO/RIO e RIO/SAO  
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "reservationCodeVolta01" junto a valor de emissão "totalOrderPriceVolta01"
    Quando seleciono tipo de pagamento "Cash"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "INVOICE" junto ao provedor "NLAT"        

    @CT02 @IdaEVolta
    Cenário: Post de emissão de reserva aerea ida e volta com um adulto e uma criança em voo SAO/MAD e MAD/SAO  
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "reservationCodeVolta02" junto a valor de emissão "totalOrderPriceVolta02"
    Quando seleciono tipo de pagamento "Cartao"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "CREDITCARD" junto ao provedor "NLAT"        

    @CT03 @IdaEVolta
    Cenário: Post de emissão de reserva aerea ida e volta com um adulto e um bebê em voo GIG/BPS e BPS/GIG  
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "reservationCodeVolta03" junto a valor de emissão "totalOrderPriceVolta03"
    Quando seleciono tipo de pagamento "Cash"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "INVOICE" junto ao provedor "NLAT"        

    @CT04 @IdaEVolta
    Cenário: Post de emissão de reserva aerea ida e volta com nove adultos em voo MAD/SAO e SAO/MAD  
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "reservationCodeVolta04" junto a valor de emissão "totalOrderPriceVolta04"
    Quando seleciono tipo de pagamento "Cartao"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "CREDITCARD" junto ao provedor "NLAT"        

    @CT05 @IdaEVolta
    Cenário: Post de emissão de reserva aerea ida e volta com um adulto e oito crianças em voo BPS/FLN e FLN/BPS  
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "reservationCodeVolta05" junto a valor de emissão "totalOrderPriceVolta05"
    Quando seleciono tipo de pagamento "Cash"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "INVOICE" junto ao provedor "NLAT"        

    @CT06 @IdaEVolta
    Cenário: Post de emissão de reserva aerea ida e volta com três adultos, três crianças e três bebÊs em voo FLN/GRU e GRU/FLN  
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "reservationCodeVolta06" junto a valor de emissão "totalOrderPriceVolta06"
    Quando seleciono tipo de pagamento "Cartao"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "CREDITCARD" junto ao provedor "NLAT"        

    @CT07 @IdaEVolta
    Cenário: Post de emissão de reserva aerea ida e volta com um adulto estrangeiro em voo DXB/GRU e GRU/DXB  
    Dado que eu tenho uma requisição de emissão de voo utilizando o tipo de request com o token de reserva "reservationCodeVolta07" junto a valor de emissão "totalOrderPriceVolta07"
    Quando seleciono tipo de pagamento "Cash"
    E envio requisição de emissão do voo "https://search-cvc-hom.reservafacil.tur.br/gwaereo/v0/flights/issue"
    Então válido Status Code 200 junto ao status de bilhete "ISSUED"
    E válido tipo de pagamento "INVOICE" junto ao provedor "NLAT"        
            