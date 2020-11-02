<template>
  <aside class="vps-sidebar" :class="{'vps-sidebar-closed':!isOpen}">
    <div class="vps-logo">
      <i class="fas fa-home"></i>
    </div>
    <div class="vps-sidebar-user" v-if="TF" id="loginTF">
      <div class="vps-sidebar-user--details">
        <div class="vps-sidebar-user-avatar">
          <avatar/>
        </div>
        <div class="vps-sidebar-user-name">
          John
          <b>Smith</b>
        </div>
        <div class="vps-sidebar-user-role">Administrator</div>
        <div
            class="vps-sidebar-user-status"
            :style="{'--status-color':true?'#06EF61':'#FB0508'}"
        >Online
        </div>
      </div>
    </div>
    <div v-else id="loginTF" class="loginTF">
      <router-link to="/login">
        <i class="fas fa-sign-in-alt">&nbsp; Sign In</i>
      </router-link>
    </div>
    <div class="vps-sidebar-search">
      <slot name="search"></slot>
    </div>
    <ul class="vps-sidebar-menu">
      <li class="vps-sidebar-menu-header">
        <h4>C-through</h4>
      </li>
      <li
          v-for="(item,index) in items"
          :key="item.label"
          class="vps-sidebar-menu-item"
          @click="expand(index)"
      >
        <div
            class="vps-sidebar-menu-item-content"
            :class="{'vps-sidebar-menu-item-content-expanded':expandedIndex===index}"
        >
          <icon
              class="vps-sidebar-menu-item-content-icon"
              :name="item.icon?item.icon:'Addon'"
              height="16px"
              width="16px"
          />
          <div class="vps-sidebar-menu-item-content-label">
            <router-link to="/Menu">
              {{ item.label }}
            </router-link>
          </div>
          <!--          <div v-if="item.details" class="vps-sidebar-menu-item-content-details">-->
          <!--            <badge :color="item.details.color" :text="item.details.text"/>-->
          <!--          </div>-->
          <icon
              name="ArrowRight"
              class="vps-sidebar-arrow"
              height="12px"
              width="12px"
              :class="{'vps-sidebar-rotate-arrow':expandedIndex===index}"
          />
        </div>
        <!--        <ul class="vps-sidebar-sub-menu expand" v-expand="index===expandedIndex">-->
        <!--          <li v-for="(child,i) in item.children" :key="i" class="vps-sidebar-sub-menu-item">-->
        <!--            <div class="vps-sidebar-sub-menu-item-label">-->
        <!--              <router-link :to="child.to?child.to:'/coming-soon'">{{ item.label }}</router-link>-->
        <!--            </div>-->
        <!--          </li>-->
        <!--        </ul>-->
      </li>
      <!--      <li class="vps-sidebar-menu-header">-->
      <!--        <h4>Extra</h4>-->
      <!--      </li>-->
      <!--      <li v-for="(item, index) in extraItems" :key="item.label" class="vps-sidebar-menu-item">-->
      <!--        <div class="vps-sidebar-menu-item-content">-->
      <!--          <icon-->
      <!--              class="vps-sidebar-menu-item-content-icon"-->
      <!--              :name="item.icon?item.icon:'Addon'"-->
      <!--              height="16px"-->
      <!--              width="16px"-->
      <!--          />-->
      <!--          <div class="vps-sidebar-menu-item-content-label">{{ item.label }}</div>-->
      <!--          <div v-if="item.details" class="vps-sidebar-menu-item-content-details">-->
      <!--            <badge :color="item.details.color" :text="item.details.text"/>-->
      <!--          </div>-->
      <!--        </div>-->
      <!--      </li>-->
      <ul class="logoutUl">
        <li class="logoutTF" v-if="TF">
          <i class="fas fa-sign-in-alt"></i>
        </li>
        <li class="logoutTF" v-if="TF">
          Log Out
        </li>
      </ul>
    </ul>

  </aside>
</template>
<script>
import expand from "../directives/expand";
import Icon from "../components/icons";
import Avatar from "../components/Avatar";
import Badge from "../components/Badge";
import EventBus from "../utils/EventBus.js";
export default {
  name: "side-bar",
  data() {
    return {
      isOpen: true,
      TF: true,
      items: [
        {
          label: "Menu",
          icon: "super-market",
        },
        {
          label: "Favorites",
          icon: "addon",
        },
        // {
        //   label: "Sign Out",
        //   icon: "Logout",
        //   TF: true
        // }
        // {
        //   label: "Charts",
        //   icon: "line-chart",
        // },
        // {
        //   label: "Maps",
        //   icon: "place",
        //   children: [
        //     {
        //       label: "Google Maps"
        //     },
        //     {
        //       label: "Open street Map"
        //     }
        //   ]
        // }
      ],
      extraItems: [
        {
          label: "Documentation",
          icon: "document",
          details: {
            text: "Beta",
            color: "#1111FF"
          }
        },
        {
          label: "Calendar",
          icon: "calendar"
        },
        {
          label: "Examples",
          icon: "gift"
        }
      ],
      expandedIndex: -1
    };
  },
  methods: {
    expand(index) {
      this.expandedIndex = this.expandedIndex === index ? -1 : index;
      this.isOpen = false;
    }
  },
  components: {
    Icon,
    Avatar,
    Badge
  },
  directives: {
    expand
  },
  mounted() {
    EventBus.$on("toggle-sidebar", isOpen => {
      this.isOpen = isOpen;
    });
  }
};
</script>
<style>
.fade-enter-active,
.fade-leave-active {
  transition: all 1s;
  max-height: 100%;
}
.fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */
{
  transform: translateY(-100%);
  height: 0;
}
.flip-list-move {
  transition: all 1s;
}
.loginTF {
  display: flex;
  justify-content: center;
  align-items: center;
}
.loginTF i {
  font-size: 18px;
}
.vps-logo i {
  font-size: 40px;
}
.logoutTF i {
  display: flex;
  justify-content: flex-end;
  padding-right: 12px;
  font-size: 18px;
}
.logoutUl {
  display: flex;
  flex-direction: row;
  justify-content: center;
  font-size: 18px;
}
</style>
