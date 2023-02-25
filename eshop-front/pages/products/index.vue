<template>
  <v-card>
    <products-product-feed :items="products"/>
  </v-card>
</template>

<script>
export default {
  name: "index",
  mounted() {
    this.fetchProducts()
  },
  data() {
    return {
      products : []
    }
  },
  methods: {
    async fetchProducts() {
      let result = await this.$axios.get('http://192.168.43.49:8080/product/list')
      this.products = result
    }
  }
}
</script>

<style scoped>

</style>
