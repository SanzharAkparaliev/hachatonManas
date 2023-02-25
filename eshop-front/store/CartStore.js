function _initialState () {
  const products = []
  return {
    products
  }
}

export const state = () => (_initialState())

export const getters = {
  getProducts(state) {
    return state.products
  },
  getTotalSum(state) {
    return state.products[0] ? state.products.map(item => item.price).reduce((a, b) => a + b) : 0
  }
}

export const mutations = {
  addProductToCart(state, product) {
    state.products.push(product)
  },
  removeProductFromCart(state, product) {
    console.log(product)
   state.products = state.products.filter(item => item.id != product.id)
  }
}

export const actions = {
  addProductToCart({commit}, product) {
    commit('addProductToCart', product)
  },
  removeProductFromCart({commit}, product) {
    commit('removeProductFromCart', product)
  },
}
