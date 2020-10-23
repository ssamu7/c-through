<template>
  <aside class="vps-sidebar" :class="{'vps-sidebar-closed':!isOpen}">
    <div class="vps-logo">
      <h3>C-Through</h3>
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
    <div v-else id="loginTF">
        <router-link to="/login">
          로그인 버튼
        </router-link>
    </div>
    <div class="vps-sidebar-search">
      <slot name="search"></slot>
    </div>
    <ul class="vps-sidebar-menu">
      <li class="vps-sidebar-menu-header">
        <h4>General</h4>
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
          <div v-if="item.details" class="vps-sidebar-menu-item-content-details">
            <badge :color="item.details.color" :text="item.details.text"/>
          </div>
          <icon
              name="ArrowRight"
              class="vps-sidebar-arrow"
              height="12px"
              width="12px"
              :class="{'vps-sidebar-rotate-arrow':expandedIndex===index}"
          />
        </div>
        <ul class="vps-sidebar-sub-menu expand" v-expand="index===expandedIndex">
          <li v-for="(child,i) in item.children" :key="i" class="vps-sidebar-sub-menu-item">
            <div class="vps-sidebar-sub-menu-item-label">
              <router-link :to="child.to?child.to:'/coming-soon'">{{ item.label }}</router-link>
            </div>
          </li>
        </ul>
      </li>
      <li class="vps-sidebar-menu-header">
        <h4>Extra</h4>
      </li>
      <li v-for="(item, index) in extraItems" :key="item.label" class="vps-sidebar-menu-item">
        <div class="vps-sidebar-menu-item-content">
          <icon
              class="vps-sidebar-menu-item-content-icon"
              :name="item.icon?item.icon:'Addon'"
              height="16px"
              width="16px"
          />
          <div class="vps-sidebar-menu-item-content-label">{{ item.label }}</div>
          <div v-if="item.details" class="vps-sidebar-menu-item-content-details">
            <badge :color="item.details.color" :text="item.details.text"/>
          </div>
        </div>
      </li>
      <li class="vps-sidebar-menu-header" v-if="TF">
        <h4>로그아웃</h4>
      </li>
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
      TF: false,
      items: [
        {
          label: "Dashboard",
          icon: "dashboard",
          details: {
            text: "New",
            color: "#FFFF11"
          }
        },
        {
          label: "Ecommerce",
          icon: "super-market",
          details: {
            text: "3",
            color: "#FF4444"
          },
          children: [
            {
              label: "Products"
            },
            {
              label: "Credit card "
            },
            {
              label: "Orders "
            }
          ]
        },
        {
          label: "Components",
          icon: "addon",
          children: [
            {
              label: "Button"
            },
            {
              label: "Table"
            },
            {
              label: "Card"
            },
            {
              label: "Alert"
            }
          ]
        },
        {
          label: "Charts",
          icon: "line-chart",
          children: [
            {
              label: "Line chart"
            },
            {
              label: "Pie chart"
            },
            {
              label: "Histogram"
            },
            {
              label: "Bar chart"
            }
          ]
        },
        {
          label: "Maps",
          icon: "place",
          children: [
            {
              label: "Google Maps"
            },
            {
              label: "Open street Map"
            }
          ]
        }
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
</style>
