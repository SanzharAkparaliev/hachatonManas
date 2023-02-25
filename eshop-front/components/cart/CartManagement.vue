<template>
  <v-card max-width="900"
          class="mx-auto">
    <v-row>
      <v-col cols="12" v-for="product in products">
        <cart-single :product="product"/>
      </v-col>
    </v-row>
    <v-card>
      <v-row class="d-flex justify-lg-end">
        <v-col>
          <v-card-title>
            Итого
          </v-card-title>
        </v-col>
        <v-col>
          <v-card-title>
            {{ totalSum }} $
          </v-card-title>
        </v-col>


        <v-col>
          <v-btn @click="purchase">Купить</v-btn>
        </v-col>
      </v-row>

    </v-card>
  </v-card>
</template>

<script>
import {mapGetters, mapState} from "vuex";
import CartSingle from "~/components/cart/CartSingle";

export default {
  name: "CartManagement",
  components: {CartSingle},
  methods: {
    purchase(){

    }
  },
  computed: {
    ...mapState('CartStore', {products: 'products'}),
    ...mapGetters('CartStore', {getTotalSum: 'getTotalSum'}),
    totalSum() {
      return this.getTotalSum
    }
  },
}
</script>

<style scoped>

</style>
