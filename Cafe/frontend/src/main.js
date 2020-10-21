import Vue from 'vue'
import App from './App.vue'
import VueComp from '@vue/composition-api'
import router from './routes';
import store from './store';


import vuetify from './plugins/vuetify';
import CardGrid from "@/components/Card/CardGrid";

Vue.use(VueComp)
Vue.use(CardGrid);

Vue.config.productionTip = false

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
