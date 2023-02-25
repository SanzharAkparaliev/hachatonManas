<template>
  <v-card
    :loading="loading"
    class="mx-auto my-12"
    max-width="374"
  >
    <template v-slot:loader="{ isActive }">
      <v-progress-linear
        :active="isActive"
        color="deep-purple"
        height="4"
        indeterminate
      ></v-progress-linear>
    </template>
    <v-carousel height="250">
      <v-carousel-item v-for="url in urls">
        <v-img
          cover
          height="250"
          :src="url"
        ></v-img>
      </v-carousel-item>
    </v-carousel>
    <v-container>
      <v-card-text>
        <v-row class="pa-2 ma-2">
          <v-card-title>{{ product.name }}</v-card-title>

          <v-card-title>
            {{ product.price }} $
          </v-card-title>
        </v-row>

      </v-card-text>
      <v-card-text>
        <v-row
          align="center"
          class="mx-0"
        >
          <v-rating
            :model-value="4.5"
            color="amber"
            density="compact"
            half-increments
            readonly
            size="small"
          ></v-rating>

          <div class="text-grey ms-4">
            4.5 (413)
          </div>

        </v-row>
        <p class="mt-5 ml-2">{{ product.description }}</p>
      </v-card-text>
      <v-card-actions>
        <v-btn
          color="deep-purple-lighten-2"
          variant="text"
          @click="addToCart(product)"
        >
          Добавить в корзину
        </v-btn>
      </v-card-actions>
    </v-container>
  </v-card>
</template>

<script>
import { mapActions } from 'vuex'
export default {
  props: ['item'],
  name: "ProductItem",
  data() {
    return {
      loading: false,
      selection: 1,
      product: this.item,
      urls: this.item.urls
    }
  },
  methods: {
    ...mapActions('CartStore', { addProductToCart: 'addProductToCart' }),
    addToCart(product) {
      this.loading = true
      this.addProductToCart(product)
      this.loading = false
    },
  },
}
</script>

<style scoped>

</style>
