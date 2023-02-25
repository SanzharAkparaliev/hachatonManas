<template>
  <v-container class="pa1">
    <v-item-group>
      <v-row>
        <v-col
          v-for="(item, i) in products"
          :key="i"
          cols="12"
          md="6"
        >
          <v-item v-slot="{ isSelected, toggle }">
            <ProductItem :item="item"/>
          </v-item>
        </v-col>
      </v-row>
    </v-item-group>
  </v-container>

</template>

<script>
import ProductItem from "~/components/products/ProductItem";
export default {
  name: "ProductFeed",
  components: {ProductItem},
  props: ['items'],
  data() {
    return{
      products: this.items,
      selection: [],
    }
  },
  watch: {
    items(newValue) {
      if (newValue) {
        this.products = newValue.data
      }
    }
  },
}
</script>

<style scoped>

</style>
