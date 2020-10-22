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
            let a = Math.random() * 10 + 1
            displayMarker(data[i], a);
            bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
          }

          // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
          map.setBounds(bounds);
        }
      }

      function displayMarker(place, a) {
        // 마커를 생성하고 지도에 표시합니다
        let imageSrc = ''
        if (a > 3 && a < 7) {
          imageSrc = 'http://snowysol.myqnapcloud.com:8080/share.cgi/cafe2.jpg?ssid=0AIuji8&fid=0AIuji8&open=normal&ep='
        } else if (a > 7) {
          imageSrc = 'https://lh3.googleusercontent.com/YO5ugyqHY-xVfRN59e2TYM0W2HXI54_6xYsanbZFFwLia7F3xmIQgIR4EPr-6bY1DqNLySODdcTUSn2Kvw6Sh8tEkwDASe_7l0zme3IUYEb6_8m58ZPW93EOkQMjgUJpHsBJG1IICPdD3NG4n-oGub9eXbXp4XrfaWGOY5gG1JTqMOcodSaOpmLFjDoen-zZd_3F1IZzZO-vrc_ci347lc7Ld-o_1KzgmuxCFCGMFch1esTpzkE7qlzKuVDCOVta_Rk9uv5KvzDrTHcyAz5Qo4UlxIdnjImm3JFU6XBAgsdI5hnVGrP-8oLz8ekJ5fflgwJ4jNSLRoBml3sJl6nnZzuW1hPSHtAPhKwvjBK_cVXGOasfoHxcmC_T9b-xr_EoY-O9vn1aBFOXRX0c2dO0fRSc3hyL8mEejlF6R95zAwpukIJ-lCFNee-71bDRGSg-2XjFEQgv9cQTfT_BRUAvrraJscqRhz5ldxg-cNkPtKXYMb2aqTKm2xomcJK8eOVxalXZiATNEG7cUJVri11KPxbylPXd3gQef1ZgzfkdKY_sinUD7cmEL2qDKQrJMESphUmqOPVCRgOn7WvSi0NrEdfG7aOEZMVYXt0uMXYxBrZh45AizP7NyQR8zVikyzBM27yicBVoq7sep_ldotFjmU033kOgCW9qhv866xyS4q3IuKOLNRp_fX1ERVD6=s104-no?authuser=0'
        } else {
          imageSrc = 'https://lh3.googleusercontent.com/YbXdeZwOErusm4AET3d9b0GCxnMB-i5kS_3KsZjbcBrXdBp3wUMgUdNrfv_AKAyzlsP8STJ6jY0mZrHatTdBGrLYIyMwBzsMZwRC6Yyx_iv1H0BN27V83yPJsZYwkKmIgLY_UWR_s1uwaBegfOP6KxuY_N0qW5bWeq2ZR4THhGJD9ysFyjrA4C1BkG3MvVjx6LCbEaFFkfwr7WmWPBHR8it71i8THO1Qs7S6ZS_n2zWGDMnRb2990qZagDt9S6Qyj59Xi5KSCI7r6Sg-xQp9L4wqfWL0neKx34d-KzyNBo55VXf3VtI2xbt7r87x7EbE5O5mb7mNLHgypI2VgbmDBztdLoWbkowwMJ3eM4MwCb6gGIP4Du1YncElZB_0HxCzm2pW__BxN--BV7JduKl1LhHGWAofqgnIXHBboIhZwSZ_cgSGYf-JRaJuR52CjJVmKTZxQxp_vWR-RFAEcCwuTJ52uLvPKMazYt-BtstjlUxZqElZwS1DP8-_t8Z26xY9-x_s1ksxhu4_O6uY3jzhigaLB6ABiebyqXaJGsbXTt4_VSvMYidEvLpKfUzgjfPyA7NZj2IZ0ZtJfqh0FJ1ZBrVL1bvn5o5Zwuf2fCE-XDzYrb-1p85hlVQb0dLbMVSi3RUGnepFQ_bnQEZaCe60athPfeihHrQypbpODqP5aC1DynWUZI9qqVmfhsnc=s104-no?authuser=0'
        }
        console.log(a)
        let imageSize = new kakao.maps.Size(65, 65)


        let markerPositon = new kakao.maps.LatLng(place.y, place.x),
            markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize)

        let marker = new kakao.maps.Marker({
          image: markerImage,
          position: markerPositon
        });

        marker.setMap(map);


        // 인포윈도우를 생성하고 지도에 표시합니다
        // let content = '<div sytle="font-size:12px;">hi</div>' +
        //                 '<div style="padding:50px;font-size:12px;">' +
        //                 '<a href="https://www.naver.com" style="color:#ff0000" target="_blank">' +
        //                 place.place_name + '(체크)</div>'
        // let content = '<div class="overlaybox">' +
        //     '    <div class="boxtitle"></div>' +
        //     '    <div class="first">' +
        //     '        <div class="placeName text">' + place.place_name + '</div>' +
        //     '    </div>' +
        //     '    <ul>' +
        //     '        <li>' +
        //     '            <span class="title">혼잡도'+ '</span>' +
        //     '        </li>' +
        //     '        <li>' +
        //     '            <span class="title">즐겨찾기</span>' +
        //     '        </li>' +
        //     '    </ul>' +
        //     '</div>';;

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
  width: 100vw;
  height: 100vh;
  padding: 50px 50px 50px 50px;
}

/*.overlaybox {*/
/*  position: relative;*/
/*  width: 360px;*/
/*  height: 350px;*/
/*  background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/box_movie.png') no-repeat;*/
/*  padding: 15px 10px;*/
/*}*/
/*.overlaybox li {*/
/*  list-style: none;*/
/*}*/
/*!* css main image*!*/
/*.overlaybox .first {*/
/*  position: relative;*/
/*  width: 247px;*/
/*  height: 136px;*/
/*  background: url('https://img.lovepik.com/photo/40155/7458.jpg_wh860.jpg');*/
/*  background-size: 247px 136px;*/
/*  margin-bottom: 8px;*/
/*}*/
/*.first .text {*/
/*  color: white;*/
/*  font-weight: bold;*/
/*}*/
/*.first .placeName {*/
/*  position: absolute;*/
/*  width: 100%;*/
/*  bottom: 0;*/
/*  background: rgba(0, 0, 0, 0.4);*/
/*  padding: 7px 15px;*/
/*  font-size: 14px;*/
/*}*/
/*.overlaybox ul {*/
/*  width: 247px;*/
/*}*/
/*.overlaybox li {*/
/*  position: relative;*/
/*  margin-bottom: 2px;*/
/*  background: #2b2d36;*/
/*  padding: 5px 10px;*/
/*  color: #aaabaf;*/
/*  line-height: 1;*/
/*}*/
/*.overlaybox li span {*/
/*  display: inline-block;*/
/*}*/
/*.overlaybox li .title {*/
/*  font-size: 13px;*/
/*}*/
/*.overlaybox li:hover {*/
/*  color: #fff;*/
/*  background: #d24545;*/
/*}*/


</style>