FROM node:18.17.1 as angular
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

FROM nginx:1.24.0-alpine as product
COPY --from=angular /app/dist/task-task-boom /usr/share/nginx/html
EXPOSE 80


