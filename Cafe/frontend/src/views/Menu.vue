<template>
  <v-card color="basil" >
    <v-card-title class="text-center justify-center py-6">
      <h1 class="font-weight-bold display-3 basil--text">Menu</h1>
      <v-btn id="hoi">주문하기</v-btn>
    </v-card-title>
    <v-tabs
        v-model="tab"
        background-color="transparent"
        color="black"
        grow
    >
      <v-tab
          v-for="item in items"
          :key="item"
      >
        {{ item }}
      </v-tab>
    </v-tabs>
    <v-tabs-items v-model="tab">
      <v-tab-item
          v-for="item in items"
          :key="item"
      >
        <v-card
            color="basil"
            flat
            v-if="item === 'Coffee'"
        >
          <CardGrid :events="events1" :buttonText="'주문하기'" buttonClicked="eventHandler()" />
        </v-card>

        <v-card
            color="basil"
            flat
            v-if="item === 'Frappuccino'"
        >
          <CardGrid :events="events2" :buttonText="'주문하기'" buttonClicked="eventHandler()" />
        </v-card>

        <v-card
            color="basil"
            flat
            v-if="item === 'Juice'"
        >
          <CardGrid :events="events3" :buttonText="'주문하기'" buttonClicked="eventHandler()" />
        </v-card>

        <v-card
            color="basil"
            flat
            v-if="item === 'Tea'"
        >
          <CardGrid :events="events4" :buttonText="'주문하기'" buttonClicked="eventHandler()" />
        </v-card>
      </v-tab-item>
    </v-tabs-items>
  </v-card>
</template>

<script>
import CardGrid from "@/components/Card/CardGrid";
import axios from 'axios';
export default {
  name: "Menu",
  components: {
    CardGrid
  },
  mounted() {
    console.log('mounted')
    axios.post('http://localhost:1234/menus')
        .then (res => {
          console.log(res.data)
        })
  },
  data () {
    return {
      tab: null,

      items: [
        'Coffee', 'Frappuccino', 'Juice', 'Tea'
      ],
      events1: [
        {
          name: "아메리카노",
          price: "₩4100",
          description:
              "강렬한 에스프레소 샷에 뜨거운 물의 조화",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2015/08/[110563]_20150813222100205.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2015/08/[110563]_20150813222100205.jpg",
          details: {
            "Team Size": "2",
            Time: "10AM - 1PM"
          }
        }
      ],
      events2: [
        {
          name: "카라멜 프라푸치노",
          price: "₩5600",
          description:
              "카라멜 시럽이 더해진 커피 프라푸치노에 휘핑 크림, 카라멜이 장식된 음료." +
              "라이트 프라푸치노용 시럽 선택 가능-Tall 사이즈 기준, 25% 이상 줄어든 저당(Low Sugar)으로 즐기실 수 있습니다.",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2015/08/[168010]_20150813220355957.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2015/08/[168010]_20150813220355957.jpg",
          details: {
            "Team Size": "2",
            Time: "10AM - 1PM"
          }
        }
      ],
      events3: [
        {
          name: "수박주스",
          price: "4000",
          description:
              "수박의 시원함과 달콤함이 풍성하게 느껴지는 주스",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2019/06/[9300000002115]_20190626101440361.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2019/06/[9300000002115]_20190626101440361.jpg",
          details: {
            "Team Size": "2",
            Time: "10AM - 1PM"
          }
        }
      ],
      events4: [
        {
          name: "유자 민트 티",
          price: "5600",
          description:
              "달콤한 유자와 알싸하고 은은한 진저,\n" +
              "우릴 수록 상쾌한 민트 티가 조화로운 유자 민트 티입니다.",
          outerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2020/06/[9200000002956]_20200616103415670.jpg",
          innerImage: "https://image.istarbucks.co.kr/upload/store/skuimg/2020/06/[9200000002956]_20200616103415670.jpg",
          details: {
            "Team Size": "2",
            Time: "10AM - 1PM"
          }
        }
      ],
      methods: {
        eventHandler() {
          console.log('button clicked');
        }
      },
    }
  }
}
</script>

<style scoped>
.basil {
  background-color: #FFFBE6;
}
.basil--text {
  color: #356859;
}

#hoi {
  display: flex;
  padding: 0 24px 0 24px;
  left: 600px;
  font-size: 22px;
  color: #356859;
  border-radius: 5px;
  font-weight: bold;
}
@media only screen and (max-width: 768px) {
  .title {
    font-size: 10vw;
  }
}

div.card {
  margin: 40px 40px;
}

</style>
