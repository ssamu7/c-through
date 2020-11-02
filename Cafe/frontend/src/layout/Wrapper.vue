<template>
  <div :class="classObject">
      <side-bar>
        <template v-if="sidebarOpen" v-slot:toolbar>
          <toolbar :isIntop="false"/>
        </template>
        <template v-if="sidebarOpen" #search>
          <input-search/>
        </template>
      </side-bar>
      <vps-header>
        <template  #search>
          <transition name="move-input">
            <input-search v-if="!sidebarOpen"/>
          </transition>
        </template>
      </vps-header>
    <main-content/>
  </div>
</template>


<script>
import SideBar from "./SideBar.vue";
import Header from "./Header.vue";
import MainContent from "./MainContent.vue";
import EventBus from "../utils/EventBus.js";
import Toolbar from "../components/bars/Toolbar.vue";
import InputSearch from "../components/form/InputSearch";
import Home from "@/views/Home.vue";
import "./style.scss";
export default {
  name: "wrapper",
  computed: {
    classObject() {
      return [
        "vps-wrapper",
        !this.sidebarOpen ? "vps-wrapper-sidebar--closed" : ""
      ];
    }
  },
  data() {
    return {
      sidebarOpen: true
    };
  },
  components: {
    SideBar,
    "vps-header": Header,
    Home,
    MainContent,
    EventBus,
    Toolbar,
    InputSearch
  },
  methods: {
    changeCSSVars() {
      document.documentElement.style.setProperty(
        "--toolbar-tran-x",
        `-${window.innerWidth}px`
      );
      document.documentElement.style.setProperty(
        "--toolbar-tran-y",
        `${window.innerHeight}px`
      );
    }
  },
  mounted() {
    EventBus.$on("toggle-sidebar", isOpen => {
      this.sidebarOpen = isOpen;
    });
    this.changeCSSVars();
    window.addEventListener("resize", () => {
      this.changeCSSVars();
    });
  }
};
</script>

<style>
.move-enter-active,
.move-leave-active,.move-input-enter-active,.move-input-leave-active {
  transition: all .8s;
}
.move-enter, .move-leave-to /* .move-leave-active below version 2.1.8 */ {
  transform: translate(var(--toolbar-tran-x), var(--toolbar-tran-y));
}

.move-input-enter, .move-input-leave-to{
  transform: translate(-610px, 154px);

}
</style>
