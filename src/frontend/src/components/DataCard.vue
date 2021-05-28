<template>
  <v-card class="mb-3">
    <v-card-title>
      <v-text-field
        style="font-size:1.5rem"
        :disabled="!item.updatable"
        v-model="item.content"
        rounded
        filled
        dense
      ></v-text-field>
    </v-card-title>
    <v-card-text> </v-card-text>
    <v-card-actions class="pt-0">
      <template v-if="item.updatable == false">
        <v-btn text color="red accent-4" @click="deleteItem(item.id)">
          삭제
        </v-btn>
        <v-btn text color="teal accent-4" @click="changeUpdatable(item)">
          수정
        </v-btn>
      </template>
      <template v-else>
        <v-btn text color="red accent-4" @click="changeUpdatable(item)">
          취소
        </v-btn>
        <v-btn
          text
          color="teal accent-4"
          @click="updateItem(type, item.id, item.content)"
        >
          완료
        </v-btn>
      </template>
    </v-card-actions>
  </v-card>
</template>

<script>
// import axios from "axios";

export default {
  props: {
    item: Object,
    type: String
  },
  data() {
    return {};
  },
  methods: {
    changeUpdatable(item) {
      if (item.updatable === undefined) {
        item.updatable = true;
      } else {
        item.updatable = !item.updatable;
      }
    },
    async updateItem(type, id, content) {
      this.$store.dispatch("updateItem", {
        type: type,
        id: id,
        content: content
      });
    },
    async deleteItem(id) {
      await this.$store.dispatch("deleteItem", { type: this.type, id: id });
    }
  }
};
</script>

<style></style>
