FROM node:16-alpine

WORKDIR /app

COPY package*.json ./
RUN npm install

COPY . .

RUN npm run build

FROM nginx:alpine
COPY --from=0 /app/build /usr/share/ngix/html


#expose the port the app runs on
EXPOSE 80

#start Nginxserver
CMD [ "nginx", "-g", "daemon off;" ]
