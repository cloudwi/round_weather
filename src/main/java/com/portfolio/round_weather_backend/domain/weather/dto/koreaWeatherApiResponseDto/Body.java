package com.portfolio.round_weather_backend.domain.weather.dto.koreaWeatherApiResponseDto;

public class Body {

    private String dataType;
    private Items items;
    private String pageNo;
    private String numOfRows;
    private String totalCount;

    public Body() {
    }

    public Body(String dataType, Items items, String pageNo, String numOfRows, String totalCount) {
        this.dataType = dataType;
        this.items = items;
        this.pageNo = pageNo;
        this.numOfRows = numOfRows;
        this.totalCount = totalCount;
    }

    public String getDataType() {
        return dataType;
    }

    public Items getItems() {
        return items;
    }

    public String getPageNo() {
        return pageNo;
    }

    public String getNumOfRows() {
        return numOfRows;
    }

    public String getTotalCount() {
        return totalCount;
    }

    @Override
    public String toString() {
        return "Body{" +
                "dataType='" + dataType + '\'' +
                ", items=" + items +
                ", pageNo='" + pageNo + '\'' +
                ", numOfRows='" + numOfRows + '\'' +
                ", totalCount='" + totalCount + '\'' +
                '}';
    }
}

