import Vue from 'vue'
import App from './App.vue'
import VueComp from '@vue/composition-api'
Vue.config.productionTip = false
import router from './routes';
import store from './store';
import vuetify from './plugins/vuetify';

Vue.use(VueComp)

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
