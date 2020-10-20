<template>
  <div>
    <div id="map" class="map"></div>
  </div>
</template>

<script>
export default {
mounted() {
    window.kakao && window.kakao.maps
      ? this.addKakaoMapScript()
      : this.initMap();
  },
  methods: {
    addKakaoMapScript() {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "http:////dapi.kakao.com/v2/maps/sdk.js?appkey=aeb90d46ca50b2629ab2d7f26488cf71&libraries=services";
      document.head.appendChild(script);
    },
    initMap() {
       let infowindow = new kakao
            .maps
            .InfoWindow({zIndex: 1});

        let mapContainer = document.getElementById("map");
        let options = {
            center: new kakao
                .maps
                .LatLng(37.5704163, 126.983138),
            level: 3
        };
        //map에 지도를 생성
        let map = new kakao
            .maps
            .Map(mapContainer, options);

        //장소 검색 객체를 생성합니다.
        let ps = new kakao
            .maps
            .services
            .Places();

        ps.keywordSearch('종각 비트캠프', placesSearchCB);
        ps.keywordSearch('종로2가 카페', placesSearchCB);
        ps.keywordSearch('종각역 카페', placesSearchCB);

        // 키워드 검색 완료 시 호출되는 콜백함수 입니다
        function placesSearchCB(data, status, pagination) {
            if (status === kakao.maps.services.Status.OK) {

                // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해 LatLngBounds 객체에 좌표를 추가합니다
                let bounds = new kakao
                    .maps
                    .LatLngBounds();

                for (let i = 0; i < data.length; i++) {
                    displayMarker(data[i]);
                    bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
                }

                // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
                map.setBounds(bounds);
            }
        }

        function displayMarker(place) {
            // 마커를 생성하고 지도에 표시합니다
            let imageSrc = 'http://snowysol.myqnapcloud.com:8080/share.cgi/cafe.jpg?ssid=0EgpcoT&fid=0EgpcoT&open=normal&ep=',
                imageSize = new kakao.maps.Size(60, 60)

            let markerPositon = new kakao.maps.LatLng(place.y, place.x),
                markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize)
            let marker = new kakao.maps.Marker({ 
              image: markerImage,
              position: markerPositon
            });
            marker.setMap(map);
            // 인포윈도우를 생성하고 지도에 표시합니다
            let content = '<div sytle="font-size:12px;">hi</div>' + 
                            '<div style="padding:50px;font-size:12px;">' +
                            '<a href="https://www.naver.com" style="color:red" target="_blank">' + 
                            place.place_name + '(체크)</div>'     
            kakao
            .maps
            .event
            .addListener(marker, 'click', function () {
                // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
                infowindow.setContent(content);
                infowindow.open(map, marker)
            });
        }
    }
  }
};
</script>

<style>
.map {
  width: 100%;
  height: 840px;
}
</style>