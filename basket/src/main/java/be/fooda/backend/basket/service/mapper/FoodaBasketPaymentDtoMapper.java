package be.fooda.backend.basket.service.mapper;

import be.fooda.backend.basket.model.dto.FoodaBasketPaymentDto;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketPaymentReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketPaymentRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;

public class FoodaBasketPaymentDtoMapper implements FoodaDtoMapper<FoodaBasketPaymentDto, FoodaBasketPaymentReq, FoodaBasketPaymentRes> {

    @Override
    public FoodaBasketPaymentDto requestToDto(FoodaBasketPaymentReq req) {

        return FoodaBasketPaymentDto.builder()
                .amount(req.getAmount())
                .basketPaymentId(req.getPaymentId())
                .paymentId(req.getPaymentId())
                .build();
    }

    @Override
    public FoodaBasketPaymentDto responseToDto(FoodaBasketPaymentRes res) {

        return FoodaBasketPaymentDto.builder()
                .paymentId(res.getPaymentId())
                .basketPaymentId(res.getBasketPaymentId())
                .amount(res.getAmount())
                .build();
    }

    @Override
    public FoodaBasketPaymentReq dtoToRequest(FoodaBasketPaymentDto dto) {

        return FoodaBasketPaymentReq.builder()
                .paymentId(dto.getPaymentId())
                .amount(dto.getAmount())
                .build();
    }

    @Override
    public FoodaBasketPaymentRes dtoToResponse(FoodaBasketPaymentDto dto) {

        return FoodaBasketPaymentRes.builder()
                .paymentId(dto.getPaymentId())
                .basketPaymentId(dto.getBasketPaymentId())
                .amount(dto.getAmount())
                .build();
    }
}
