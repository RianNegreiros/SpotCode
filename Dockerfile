FROM ruby:3.0.0

ENV BUNDLER_VERSION=2.2.3

RUN apt-get update -qq \
&& apt-get install -y curl build-essential libpq-dev \
 nodejs sqlite3 &&\
  curl -sL https://deb.nodesource.com/setup_15.x | bash - && \
  curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | apt-key add - && \
  echo "deb https://dl.yarnpkg.com/debian/ stable main" | tee /etc/apt/sources.list.d/yarn.list && \
  apt-get update && apt-get install -y nodejs yarn

RUN gem install bundler -v 2.2.3

WORKDIR /app

COPY Gemfile Gemfile.lock ./
RUN bundle config build.nokogiri --use-system-libraries
RUN bundle check || bundle install

COPY package.json yarn.lock ./
RUN yarn install --check-files

COPY . ./ 

ENTRYPOINT ["./entrypoints/docker-entrypoint.sh"]