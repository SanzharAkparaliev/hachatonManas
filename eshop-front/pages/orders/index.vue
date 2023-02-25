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

    <v-img
      cover
      height="250"
      src="https://www.google.com/imgres?imgurl=https%3A%2F%2Fstatic.displate.com%2F857x1200%2Fdisplate%2F2019-12-08%2F5cc1470d0feb9207c509dc82280fb762_e43f1a64ae9bc5cf9f0f1375b7883d50.jpg&imgrefurl=https%3A%2F%2Fdisplate.com%2Fdisplate%2F1559154&tbnid=Au7RjbTTCS9vnM&vet=12ahUKEwjr8Me0nq_9AhXmsYsKHVTlAAAQMygTegUIARCQAg..i&docid=1H6nwVL8spmS2M&w=857&h=1200&q=ricardo%20milos&client=ubuntu&ved=2ahUKEwjr8Me0nq_9AhXmsYsKHVTlAAAQMygTegUIARCQAg"
    ></v-img>

    <v-card-text>
      <v-card-title>Cafe Badilico</v-card-title>

      <v-card-subtitle>
        <span class="me-1">Local Favorite</span>

        <v-icon
          color="error"
          icon="mdi-fire-circle"
          size="small"
        ></v-icon>
      </v-card-subtitle>
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
      <div>Small plates, salads & sandwiches - an intimate setting with 12 indoor seats plus patio seating.</div>
    </v-card-text>
    <v-card-actions>
      <v-btn
        color="deep-purple-lighten-2"
        variant="text"
        @click="reserve"
      >
        Reserve
      </v-btn>
    </v-card-actions>
  </v-card>
</template>


<script>
export default {
  name: "index",
  data () {
    return {
      loading: false,
      selection: 1,
    }
  },
  methods: {
    reserve() {
      this.loading = true

      setTimeout(() => (this.loading = false), 2000)
    },
  },
}
</script>

<style scoped>

</style>
