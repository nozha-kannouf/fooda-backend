package be.fooda.backend.commons.service.mapper;
import be.fooda.backend.commons.model.template.media.dto.FoodaMediaStoreDto;
import be.fooda.backend.commons.model.template.media.dto.FoodaMediaTypeDto;
import be.fooda.backend.commons.model.template.media.request.FoodaMediaStoreInfoReq;
import be.fooda.backend.commons.model.template.media.request.FoodaMediaStoreReq;
import be.fooda.backend.commons.model.template.media.request.FoodaMediaTypeReq;
import be.fooda.backend.commons.model.template.media.response.FoodaMediaStoreInfoRes;
import be.fooda.backend.commons.model.template.media.response.FoodaMediaStoreRes;
import be.fooda.backend.commons.model.template.media.response.FoodaMediaTypeRes;

public class FoodaMediaStoreMapper implements FoodaObjectMapper<FoodaMediaStoreDto, FoodaMediaStoreReq, FoodaMediaStoreRes> {
    @Override
    public FoodaMediaStoreReq dtoToRequest(FoodaMediaStoreDto storeDto) {
        return FoodaMediaStoreReq.builder()
                .storeMediaId(storeDto.getStoreMediaId())
                .url(storeDto.getUrl())
                .store(storeInfoReq(storeDto))
                .type(typeReq(storeDto))
                .build();
    }

    private FoodaMediaTypeReq typeReq(FoodaMediaStoreDto storeDto) {
        return FoodaMediaTypeReq.builder()
                .typeId(storeDto.getType().getTypeId())
                .title(storeDto.getType().getTitle())
                .extension(storeDto.getType().getExtension())
                .build();
    }

    private FoodaMediaStoreInfoReq storeInfoReq(FoodaMediaStoreDto storeDto) {
        return FoodaMediaStoreInfoReq.builder()
                .storeId(storeDto.getStoreId())
                //.name(storeDto.)
                .build() ;
    }

    @Override
    public FoodaMediaStoreReq responseToRequest(FoodaMediaStoreRes storeRes) {
        return FoodaMediaStoreReq.builder()
                .type(typeReq(storeRes))
                .store(storeInfoReq(storeRes))
                .url(storeRes.getUrl())
                .storeMediaId(storeRes.getStoreMediaId())
                .build();
    }
    private FoodaMediaTypeReq typeReq(FoodaMediaStoreRes storeRes) {
        return FoodaMediaTypeReq.builder()
                .typeId(storeRes.getType().getTypeId())
                .title(storeRes.getType().getTitle())
                .extension(storeRes.getType().getExtension())
                .build();
    }

    private FoodaMediaStoreInfoReq storeInfoReq(FoodaMediaStoreRes storeRes) {
        return FoodaMediaStoreInfoReq.builder()
                .storeId(storeRes.getStore().getStoreId())
                .name(storeRes.getStore().getName())
                .build() ;
    }
    @Override
    public FoodaMediaStoreRes dtoToResponse(FoodaMediaStoreDto storeDto) {
        FoodaMediaStoreRes storeRes=new FoodaMediaStoreRes();
        storeDto.setStoreId(storeDto.getStoreId());
        storeDto.setStoreMediaId(storeDto.getStoreMediaId());
        storeDto.setUrl(storeDto.getUrl());
        storeDto.setType(typeDto(storeDto));
        return storeRes;
    }

    private FoodaMediaTypeDto typeDto(FoodaMediaStoreDto storeDto) {
        return FoodaMediaTypeDto.builder()
                .extension(storeDto.getType().getExtension())
                .title(storeDto.getType().getTitle())
                .typeId(storeDto.getType().getTypeId())
                .build();
    }

    @Override
    public FoodaMediaStoreRes requestToResponse(FoodaMediaStoreReq  storeReq) {
        FoodaMediaStoreRes mediaStoreRes=new FoodaMediaStoreRes();
        mediaStoreRes.setUrl(storeReq.getUrl());
        mediaStoreRes.setStoreMediaId(storeReq.getStoreMediaId());
        mediaStoreRes.setType(typeRes(storeReq));
        mediaStoreRes.setStore(storeInfoRes(storeReq));
        return mediaStoreRes;
    }

    private FoodaMediaStoreInfoRes storeInfoRes(FoodaMediaStoreReq storeReq) {
        FoodaMediaStoreInfoRes mediaStoreInfoRes=new FoodaMediaStoreInfoRes();
        mediaStoreInfoRes.setStoreId(storeReq.getStore().getStoreId());
        mediaStoreInfoRes.setName(storeReq.getStore().getName());
        return null;
    }

    private FoodaMediaTypeRes typeRes(FoodaMediaStoreReq storeReq) {
        FoodaMediaTypeRes mediaTypeRes=new FoodaMediaTypeRes();
        mediaTypeRes.setTitle(storeReq.getType().getTitle());
        mediaTypeRes.setTypeId(storeReq.getType().getTypeId());
        mediaTypeRes.setExtension(storeReq.getType().getExtension());
        return mediaTypeRes;
    }

    @Override
    public FoodaMediaStoreDto requestToDto(FoodaMediaStoreReq storeReq) {

        return FoodaMediaStoreDto.builder()
                .storeId(storeReq.getStore().getStoreId())
                .storeMediaId(storeReq.getStoreMediaId())
                .type(typeDto(storeReq))
                .url(storeReq.getUrl())
                .build();
    }
    private FoodaMediaTypeDto typeDto(FoodaMediaStoreReq storeReq) {
        return FoodaMediaTypeDto.builder()
                .typeId(storeReq.getType().getTypeId())
                .title(storeReq.getType().getTitle())
                .extension(storeReq.getType().getExtension())
                .build();

    }
    @Override
    public FoodaMediaStoreDto responseToDto(FoodaMediaStoreRes storeRes) {
        return FoodaMediaStoreDto.builder()
                .url(storeRes.getUrl())
                .type(typeDto(storeRes))
                .storeMediaId(storeRes.getStoreMediaId())
                .storeId(storeRes.getStore().getStoreId())
                .build();
    }
    private FoodaMediaTypeDto typeDto(FoodaMediaStoreRes storeRes){
        return FoodaMediaTypeDto.builder()
                .extension(storeRes.getType().getExtension())
                .title(storeRes.getType().getTitle())
                .typeId(storeRes.getType().getTypeId())
                .build();
    }

}
