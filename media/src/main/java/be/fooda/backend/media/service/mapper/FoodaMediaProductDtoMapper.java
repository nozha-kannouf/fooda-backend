package be.fooda.backend.media.service.mapper;

import be.fooda.backend.commons.model.template.media.request.*;
import be.fooda.backend.commons.model.template.media.response.*;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.media.model.dto.FoodaMediaProductDto;
import be.fooda.backend.media.model.dto.FoodaMediaProductKeyDto;
import be.fooda.backend.media.model.dto.FoodaMediaTypeDto;

public class FoodaMediaProductDtoMapper implements FoodaDtoMapper<FoodaMediaProductDto, FoodaMediaProductReq, FoodaMediaProductRes> {
    @Override
    public FoodaMediaProductDto requestToDto(FoodaMediaProductReq foodaMediaProductReq) {
        return FoodaMediaProductDto.builder()
                .productKey(productKeyDto(foodaMediaProductReq))
                .mediaProductId(foodaMediaProductReq.getProductMediaId())
                .url(foodaMediaProductReq.getUrl())
                .type(mediaTypeDto(foodaMediaProductReq))
                .build();

    }

    private FoodaMediaProductKeyDto productKeyDto(FoodaMediaProductReq foodaMediaProductReq) {
            return FoodaMediaProductKeyDto.builder()
                    .productId(foodaMediaProductReq.getProduct().getProductId())
                    .storeId(foodaMediaProductReq.getStore().getStore().getStoreId())
                    .build();

    }

    private FoodaMediaTypeDto mediaTypeDto(FoodaMediaProductReq req) {
        return FoodaMediaTypeDto.builder()
                .extension(req.getType().getExtension())
                .title(req.getType().getTitle())
                .typeId(req.getType().getTypeId())
                .build();
    }





    @Override
    public FoodaMediaProductDto responseToDto(FoodaMediaProductRes foodaMediaProductRes) {
        return FoodaMediaProductDto.builder()
                .url(foodaMediaProductRes.getUrl())
                .type(mediaTypeDto(foodaMediaProductRes))
                .mediaProductId(foodaMediaProductRes.getProductMediaId())
                .productKey(productKeyDto(foodaMediaProductRes))
                .build();
    }
    private FoodaMediaProductKeyDto productKeyDto(FoodaMediaProductRes res) {
        return FoodaMediaProductKeyDto.builder()
                .productId(res.getProduct().getProductId())
                .storeId(res.getStore().getStore().getStoreId())
                .build();
    }
    private FoodaMediaTypeDto mediaTypeDto(FoodaMediaProductRes res) {
        return FoodaMediaTypeDto.builder()
                .extension(res.getType().getExtension())
                .title(res.getType().getTitle())
                .typeId(res.getType().getTypeId())
                .build();
    }

    @Override
    public FoodaMediaProductReq dtoToRequest(FoodaMediaProductDto foodaMediaProductDto) {
        return FoodaMediaProductReq.builder()
                .productMediaId(foodaMediaProductDto.getMediaProductId())
                .product(product(foodaMediaProductDto))
                .url(foodaMediaProductDto.getUrl())
                .type(type(foodaMediaProductDto))
                .store(store(foodaMediaProductDto))
                .build();

    }

    private FoodaMediaProductInfoReq product(FoodaMediaProductDto dto) {
        return FoodaMediaProductInfoReq.builder()
                .productId(dto.getProductKey().getProductId())
                //.name(dto.)
                .build();
    }

    private FoodaMediaStoreReq store(FoodaMediaProductDto dto) {
        return FoodaMediaStoreReq.builder()
                .store(storeInfo(dto))
                .url(dto.getUrl())
                .type(type(dto))
                //.storeMediaId(dto.getProductMediaId())
                .build();
    }

    private FoodaMediaStoreInfoReq storeInfo(FoodaMediaProductDto dto) {
        return FoodaMediaStoreInfoReq.builder()
                .storeId(dto.getProductKey().getStoreId())
                //.name(dto
                .build();
    }

    private FoodaMediaTypeReq type(FoodaMediaProductDto dto) {
        return FoodaMediaTypeReq.builder()
                .typeId(dto.getType().getTypeId())
                .title(dto.getType().getTitle())
                .extension(dto.getType().getExtension())
                .build();
    }

    @Override
    public FoodaMediaProductRes dtoToResponse(FoodaMediaProductDto foodaMediaProductDto) {
        final FoodaMediaProductRes mediaProductRes=new FoodaMediaProductRes();
        mediaProductRes.setProduct(productInfoRes(foodaMediaProductDto));
        mediaProductRes.setProductMediaId(foodaMediaProductDto.getMediaProductId());
        mediaProductRes.setStore(mediaStoreRes(foodaMediaProductDto));
        mediaProductRes.setType(mediaTypeRes(foodaMediaProductDto));
        mediaProductRes.setUrl(foodaMediaProductDto.getUrl());
        return mediaProductRes;
    }

    private FoodaMediaStoreRes mediaStoreRes(FoodaMediaProductDto dto) {
        final FoodaMediaStoreRes mediaStoreRes=new FoodaMediaStoreRes();
        mediaStoreRes.setUrl(dto.getUrl());
        mediaStoreRes.setStore(mediaStoreInfoRes(dto));
        mediaStoreRes.setType(mediaTypeRes(dto));
        return mediaStoreRes;
    }

    private FoodaMediaTypeRes mediaTypeRes(FoodaMediaProductDto dto) {
        final FoodaMediaTypeRes mediaTypeRes=new FoodaMediaTypeRes();
        mediaTypeRes.setExtension(dto.getType().getExtension());
        mediaTypeRes.setTitle(dto.getType().getTitle());
        mediaTypeRes.setTypeId(dto.getType().getTypeId());
        return mediaTypeRes;
    }

    private FoodaMediaStoreInfoRes mediaStoreInfoRes(FoodaMediaProductDto dto) {
        final FoodaMediaStoreInfoRes mediaStoreInfoRes=new FoodaMediaStoreInfoRes();
        mediaStoreInfoRes.setStoreId(dto.getProductKey().getStoreId());
        // mediaStoreInfoRes.setName(dto.get)
        return mediaStoreInfoRes;
    }

    private FoodaMediaProductInfoRes productInfoRes(FoodaMediaProductDto dto) {
        final FoodaMediaProductInfoRes mediaProductInfoRes=new FoodaMediaProductInfoRes();
        mediaProductInfoRes.setProductId(dto.getProductKey().getProductId());
        return mediaProductInfoRes;

    }
}
