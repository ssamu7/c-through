<template>
    <div>
      <v-data-table
          :headers="headers"
          :items="desserts"
          item-key="name"
          class="elevation-1"
          :search="search"
          :custom-filter="filterOnlyCapsText"
      >
        <template v-slot:item.complete="{ item }">
          <v-btn>asdf</v-btn>
        </template>
      </v-data-table>
    </div>
</template>

<script>
export default {
name:'coming-soon',
  computed: {
    headers () {
      return [
        {
          text: '주문 번호',
          align: 'center',
          sortable: false,
          value: 'orderNo',
        },
        {
          text: '주문자',
          value: 'nickname'
        },
        {
          text: '주문 한 것',
          value: 'orders'
        },
        {
          text: '주문 수 량',
          value: 'cafenum'
        },
        {
          text: '완료',
          value: 'complete'
        }
      ]
    },
  },
}
</script>

<style>

</style>
