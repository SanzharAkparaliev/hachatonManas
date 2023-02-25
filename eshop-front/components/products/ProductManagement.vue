<template>
  <v-card>
    <v-data-table
      :headers="getHeaders()"
      :items="products"
      :search="search"
    >

    </v-data-table>
  </v-card>

</template>

<script>
export default {
  name: "ProductManagement",
  props: ['items'],
  data() {
    return {
      products: this.items,
      search: '',
    }
  },
  watch: {
    items(newValue) {
      if (newValue) {
        this.products = newValue.data
      }
    }
  },
  methods: {
    getHeaders() {
      return [
        { text: 'ID', value: 'id' },
        { text: 'Название', value: 'name' },
        { text: 'Категория', value: 'category.name' },
        { text: 'Цена', value: 'price' },
        { text: 'Редактировать', value: 'edit' }
      ]

    }
  }
}
</script>

<style scoped>

</style>
