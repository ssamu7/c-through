<template>
  <div id="app">
    <v-app id="inspire">
      <div>C-Through
        Hoi
        <v-data-table
            :headers="headers"
            :items="orderlist"
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
      places: 'a',
      orderlist: []
    }
  },
  computed: {
    headers () {
      return [
        {
          text: '주문 번호',
          align: 'start',
          sortable: false,
          value: 'orderNo',
        },
        {
          text: '주문',
          value: 'orders'
        },
        { text: '닉네임', value: 'nickname' },
        { text: '수량', value: 'cafenum' },
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
    sleep (delay) {
      var start = new Date().getTime();
      while (new Date().getTime() < start + delay);
    }
  },
  mounted() {
    this.sleep(1000)
    const place = this.places
    axios.post('http://localhost:1234/orderby/list', {place})
        .then(res => {
          this.orderlist = res.data
        })
  }
}
</script>

<style>
</style>
