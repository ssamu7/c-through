<template>
  <div class="home">
    <v-data-table
        :headers="headers"
        :items="desserts"
        item-key="name"
        class="elevation-1"
        :search="search"
        :custom-filter="filterOnlyCapsText"
    />
  </div>
</template>

<script>

export default {
  name: "Home",
  computed: {
    headers () {
      return [
        {
          text: 'Dessert (100g serving)',
          align: 'start',
          sortable: false,
          value: 'name',
        },
        {
          text: 'Calories',
          value: 'calories',
          filter: value => {
            if (!this.calories) return true

            return value < parseInt(this.calories)
          },
        },
        { text: 'Fat (g)', value: 'fat' },
        { text: 'Carbs (g)', value: 'carbs' },
        { text: 'Protein (g)', value: 'protein' },
        { text: 'Iron (%)', value: 'iron' },
      ]
    },
  }

};
</script>
