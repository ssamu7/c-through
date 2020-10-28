<template>
  <div id="app">
    <v-app id="inspire">
      <div>C-Through
        Hoi
        <v-data-table
            :headers="headers"
            :items="desserts"
            item-key="name"
            class="elevation-1"
            :search="search"
            :custom-filter="filterOnlyCapsText"
        >
        </v-data-table>
      </div>
    </v-app>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name:'coming-soon',
  data () {
    return {
      search: '',
      calories: '',
      orderlist: [],
      desserts: [
        {
          name: 'Frozen Yogurt',
          calories: 159,
          fat: 6.0,
          carbs: 24,
          protein: 4.0,
          iron: '1%',
        },
        {
          name: 'Ice cream sandwich',
          calories: 237,
          fat: 9.0,
          carbs: 37,
          protein: 4.3,
          iron: '1%',
        },
        {
          name: 'Eclair',
          calories: 262,
          fat: 16.0,
          carbs: 23,
          protein: 6.0,
          iron: '7%',
        },
        {
          name: 'Cupcake',
          calories: 305,
          fat: 3.7,
          carbs: 67,
          protein: 4.3,
          iron: '8%',
        },
        {
          name: 'Gingerbread',
          calories: 356,
          fat: 16.0,
          carbs: 49,
          protein: 3.9,
          iron: '16%',
        },
        {
          name: 'Jelly bean',
          calories: 375,
          fat: 0.0,
          carbs: 94,
          protein: 0.0,
          iron: '0%',
        },
        {
          name: 'Lollipop',
          calories: 392,
          fat: 0.2,
          carbs: 98,
          protein: 0,
          iron: '2%',
        },
        {
          name: 'Honeycomb',
          calories: 408,
          fat: 3.2,
          carbs: 87,
          protein: 6.5,
          iron: '45%',
        },
        {
          name: 'Donut',
          calories: 452,
          fat: 25.0,
          carbs: 51,
          protein: 4.9,
          iron: '22%',
        },
        {
          name: 'KitKat',
          calories: 518,
          fat: 26.0,
          carbs: 65,
          protein: 7,
          iron: '6%',
        },
      ],
    }
  },
  computed: {
    headers () {
      return [
        {
          text: '주문 번호',
          align: 'start',
          sortable: false,
          value: 'name',
        },
        {
          text: '주문자',
          value: 'calories',
          filter: value => {
            if (!this.calories) return true
            return value < parseInt(this.calories)
          },
        },
        { text: '닉네임', value: 'fat' },
        { text: '수량', value: 'carbs' },
        { text: 'Protein (g)', value: 'protein' },
        { text: 'Iron (%)', value: 'iron' },
      ]
    },
  },
  methods: {
    filterOnlyCapsText (value, search, item) {
      return value != null &&
          search != null &&
          typeof value === 'string' &&
          value.toString().toLocaleUpperCase().indexOf(search) !== -1
    },
  },
  mounted() {
    const place = this.places
    axios.post('http://localhost:1234/orderby/list', {place})
        .then(res => {
          this.orderlist = res.data
          console.log(res.data[0])
          console.log(res.data[0].nickname)
          console.log(res.data.orders)
          console.log(res.data.cafenum)
        })
  }
}
</script>

<style>
</style>
