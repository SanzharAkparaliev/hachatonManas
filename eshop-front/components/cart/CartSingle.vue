<template>
  <v-card
    color="rgb(255,255,255,0.9)"
    theme="dark"
  >
    <div class="d-flex flex-no-wrap justify-space-between">
      <v-avatar
        class="ma-3"
        size="125"
        rounded="0"
      >
        <v-img :src="editedProduct.urls[0]"></v-img>
      </v-avatar>
      <v-row class="align-center d-flex justify-space-between">
        <v-col>
          <v-card-title class="text-h5 black--text">
            {{ editedProduct.name }}
          </v-card-title>
        </v-col>
        <v-col>
          <v-card-title class="black--text">{{ editedProduct.price }} $</v-card-title>
        </v-col>
        <v-col class="justify-end">
          <v-card-actions>
            <v-btn
              @click="removeProduct(editedProduct)"
              class="ms-2"
            >
              <v-icon>mdi-close-circle</v-icon>
            </v-btn>
          </v-card-actions>
        </v-col>
      </v-row>
    </div>
  </v-card>
</template>

<script>
import {mapActions} from "vuex";

export default {
  name: "CartSingle",
  props: ['product'],
  data() {
    return {
      editedProduct: this.product
    }
  },
  methods: {
    ...mapActions('CartStore', { removeProductFromCart: 'removeProductFromCart' }),
    removeProduct(editedProduct) {
      this.removeProductFromCart(editedProduct)
    }
  }
}
</script>

<style scoped>

</style>
