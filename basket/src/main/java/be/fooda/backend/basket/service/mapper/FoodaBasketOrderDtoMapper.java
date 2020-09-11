package be.fooda.backend.basket.service.mapper;

import be.fooda.backend.basket.model.dto.FoodaBasketKeyDto;
import be.fooda.backend.basket.model.dto.FoodaBasketOrderDto;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketOrderReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketOrderRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;

public class FoodaBasketOrderDtoMapper implements FoodaDtoMapper<FoodaBasketOrderDto, FoodaBasketOrderReq, FoodaBasketOrderRes> {

    @Override
    public FoodaBasketOrderDto requestToDto(FoodaBasketOrderReq req) {

        return FoodaBasketOrderDto.builder()
                .basketKey(reqBasketKey(req))
                .requiredTime(req.getRequiredTime())
                .note(req.getNote())
                .build();
    }

    private FoodaBasketKeyDto reqBasketKey(FoodaBasketOrderReq req) {
        return FoodaBasketKeyDto.builder()
                .session(req.getSession())
                .storeId(req.getStoreId())
                .userId(req.getUserId())
                .build();
    }

    @Override
    public FoodaBasketOrderDto responseToDto(FoodaBasketOrderRes res) {

        return FoodaBasketOrderDto.builder()
                .note(res.getNote())
                .requiredTime(res.getRequiredTime())
                .basketOrderId(res.getBasketOrderId())
                .basketKey(resBasketKey(res))
                .expiryTime(res.getExpiryTime())
                .registryTime(res.getRegistryTime())
                .build();
    }

    private FoodaBasketKeyDto resBasketKey(FoodaBasketOrderRes res) {
        return FoodaBasketKeyDto.builder()
                .userId(res.getUserId())
                .storeId(res.getStoreId())
                .session(res.getSession())
                .build();
    }

    @Override
    public FoodaBasketOrderReq dtoToRequest(FoodaBasketOrderDto dto) {

        return FoodaBasketOrderReq.builder()
                .userId(dto.getBasketKey().getUserId())
                .storeId(dto.getBasketKey().getStoreId())
                .session(dto.getBasketKey().getSession())
                .requiredTime(dto.getRequiredTime())
                .note(dto.getNote())
                .build();
    }

    @Override
    public FoodaBasketOrderRes dtoToResponse(FoodaBasketOrderDto dto) {

        return FoodaBasketOrderRes.builder()
                .basketOrderId(dto.getBasketOrderId())
                .userId(dto.getBasketKey().getUserId())
                .storeId(dto.getBasketKey().getStoreId())
                .session(dto.getBasketKey().getSession())
                .requiredTime(dto.getRequiredTime())
                .registryTime(dto.getRegistryTime())
                .note(dto.getNote())
                .expiryTime(dto.getExpiryTime())
                .build();
    }
}
