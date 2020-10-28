import Vue from 'vue'
import App from './App.vue'
import VueComp from '@vue/composition-api'
import router from './routes';
import store from './store';


import Vuetify from 'vuetify';
import CardGrid from "@/components/Card/CardGrid";
import 'vuetify/dist/vuetify.min.css'

Vue.use(VueComp)
Vue.use(CardGrid);
Vue.use(Vuetify)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  vuetify:new Vuetify(),
  render: h => h(App)
}).$mount('#app')
