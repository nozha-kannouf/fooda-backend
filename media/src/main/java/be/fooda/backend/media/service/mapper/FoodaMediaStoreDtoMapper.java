package be.fooda.backend.media.service.mapper;

import be.fooda.backend.commons.model.template.media.request.FoodaMediaStoreInfoReq;
import be.fooda.backend.commons.model.template.media.request.FoodaMediaStoreReq;
import be.fooda.backend.commons.model.template.media.request.FoodaMediaTypeReq;
import be.fooda.backend.commons.model.template.media.response.FoodaMediaStoreInfoRes;
import be.fooda.backend.commons.model.template.media.response.FoodaMediaStoreRes;
import be.fooda.backend.commons.model.template.media.response.FoodaMediaTypeRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.media.model.dto.FoodaMediaStoreDto;
import be.fooda.backend.media.model.dto.FoodaMediaTypeDto;

public class FoodaMediaStoreDtoMapper implements FoodaDtoMapper<FoodaMediaStoreDto, FoodaMediaStoreReq, FoodaMediaStoreRes> {
    @Override
    public FoodaMediaStoreDto requestToDto(FoodaMediaStoreReq foodaMediaStoreReq) {
        return FoodaMediaStoreDto.builder()
                .storeId(foodaMediaStoreReq.getStore().getStoreId())
                .url(foodaMediaStoreReq.getUrl())
                .storeMediaId(foodaMediaStoreReq.getStoreMediaId())
                .type(mediaTypeDto(foodaMediaStoreReq))
                .build();
    }

    private FoodaMediaTypeDto mediaTypeDto(FoodaMediaStoreReq foodaMediaStoreReq) {
        return FoodaMediaTypeDto.builder()
                .typeId(foodaMediaStoreReq.getType().getTypeId())
                .title(foodaMediaStoreReq.getType().getTitle())
                .extension(foodaMediaStoreReq.getType().getExtension())
                .build();
    }

    @Override
    public FoodaMediaStoreDto responseToDto(FoodaMediaStoreRes foodaMediaStoreRes) {
        return FoodaMediaStoreDto.builder()
                .storeMediaId(foodaMediaStoreRes.getStoreMediaId())
                .storeId(foodaMediaStoreRes.getStore().getStoreId())
                .url(foodaMediaStoreRes.getUrl())
                .type(mediaTypeDto(foodaMediaStoreRes))
                .build();
    }
    private FoodaMediaTypeDto mediaTypeDto(FoodaMediaStoreRes foodaMediaStoreRes) {
        return FoodaMediaTypeDto.builder()
                .typeId(foodaMediaStoreRes.getType().getTypeId())
                .title(foodaMediaStoreRes.getType().getTitle())
                .extension(foodaMediaStoreRes.getType().getExtension())
                .build();
    }

    @Override
    public FoodaMediaStoreReq dtoToRequest(FoodaMediaStoreDto foodaMediaStoreDto) {
        return FoodaMediaStoreReq.builder()
                .storeMediaId(foodaMediaStoreDto.getStoreMediaId())
                .url(foodaMediaStoreDto.getUrl())
                .store(mediaStoreInfoReq(foodaMediaStoreDto))
                .type(mediaTypeReq(foodaMediaStoreDto))
                .build();
    }

    private FoodaMediaTypeReq mediaTypeReq(FoodaMediaStoreDto foodaMediaStoreDto) {
        return FoodaMediaTypeReq.builder()
                .typeId(foodaMediaStoreDto.getType().getTypeId())
                .title(foodaMediaStoreDto.getType().getTitle())
                .extension(foodaMediaStoreDto.getType().getExtension())
                .build();
    }

    private FoodaMediaStoreInfoReq mediaStoreInfoReq(FoodaMediaStoreDto foodaMediaStoreDto) {
        return  FoodaMediaStoreInfoReq.builder()
                .storeId(foodaMediaStoreDto.getStoreId())
                .build();
    }

    @Override
    public FoodaMediaStoreRes dtoToResponse(FoodaMediaStoreDto foodaMediaStoreDto) {
        FoodaMediaStoreRes foodaMediaStoreRes=new FoodaMediaStoreRes();
        foodaMediaStoreRes.setStoreMediaId(foodaMediaStoreDto.getStoreMediaId());
        foodaMediaStoreRes.setUrl(foodaMediaStoreDto.getUrl());
        foodaMediaStoreRes.setType(mediaTypeRes(foodaMediaStoreDto));
        foodaMediaStoreRes.setStore(mediaStoreInfoRes(foodaMediaStoreDto));
        return foodaMediaStoreRes;
    }

    private FoodaMediaStoreInfoRes mediaStoreInfoRes(FoodaMediaStoreDto foodaMediaStoreDto) {
         FoodaMediaStoreInfoRes mediaStoreInfoRes=new FoodaMediaStoreInfoRes();
        mediaStoreInfoRes.setStoreId(foodaMediaStoreDto.getStoreId());
         return mediaStoreInfoRes;
    }

    private FoodaMediaTypeRes mediaTypeRes(FoodaMediaStoreDto foodaMediaStoreDto) {
        FoodaMediaTypeRes mediaTypeRes=new FoodaMediaTypeRes();
        mediaTypeRes.setTypeId(foodaMediaStoreDto.getType().getTypeId());
        mediaTypeRes.setTitle(foodaMediaStoreDto.getType().getTitle());
        mediaTypeRes.setExtension(foodaMediaStoreDto.getType().getExtension());
        return mediaTypeRes;
    }
}
