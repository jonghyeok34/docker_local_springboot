<template>
  <v-app>
    <v-app-bar absolute dark>
      <v-toolbar-title>CRUD</v-toolbar-title>
    </v-app-bar>
    <v-container class="mt-16">
      <v-card class="mb-5" flat>
        <v-card-title>ORACLE</v-card-title>
        <v-card-text>
          <v-card class="mb-3">
            <v-card-title> </v-card-title>
            <v-card-text></v-card-text>
            <v-card-actions class="pt-0">
              <v-btn text color="red accent-4">
                삭제
              </v-btn>
              <v-btn text color="teal accent-4">
                수정
              </v-btn>
            </v-card-actions>
          </v-card>
          <v-card>
            <v-card-text>
              <v-text-field name="name" label="입력값" id="id"></v-text-field>
            </v-card-text>
            <v-card-actions class="pt-0">
              <v-btn text color="teal accent-4">
                추가
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-card-text>
      </v-card>
      <v-card class="mb-5" flat>
        <v-card-title>MYSQL</v-card-title>
        <v-card-text>
          <v-card class="mb-3">
            <v-card-title> </v-card-title>
            <v-card-text></v-card-text>
            <v-card-actions class="pt-0">
              <v-btn text color="red accent-4">
                삭제
              </v-btn>
              <v-btn text color="teal accent-4">
                수정
              </v-btn>
            </v-card-actions>
          </v-card>
          <v-card>
            <v-card-text>
              <v-text-field name="name" label="입력값" id="id"></v-text-field>
            </v-card-text>
            <v-card-actions class="pt-0">
              <v-btn text color="teal accent-4">
                추가
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-card-text>
      </v-card>
    </v-container>
  </v-app>
</template>

<script>
export default {};
</script>

<style></style>
