FROM nginx:latest
ADD ./dist/css /usr/share/nginx/html/css
ADD ./dist/img /usr/share/nginx/html/img
ADD ./dist/js /usr/share/nginx/html/js
ADD ./dist/vendor /usr/share/nginx/html/vendor
ADD ./dist/homeicon2.ico /usr/share/nginx/html/
ADD ./dist/ServerErrorPage.html /usr/share/nginx/
ADD ./dist/ServerErrorPage.html /usr/share/nginx/
ADD ./dist/NotFoundErrorPage.html /usr/share/nginx/
RUN rm -rf /usr/share/nginx/html/index.html
ADD ./dist/index.html /usr/share/nginx/html/index.html
RUN rm -rf /etc/nginx/conf.d/default.conf
ADD ./nginx/default.conf /etc/nginx/conf.d/default.conf
ADD ./cert/certificate.crt /etc/nginx/certificate.crt
ADD ./cert/private.key /etc/nginx/private.key
ENV TZ=Asia/Seoul
CMD ["nginx", "-g", "daemon off;"]