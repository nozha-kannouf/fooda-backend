package it.vkod.woo.store.generator.service.srv.impl;

import com.github.javafaker.Faker;
import it.vkod.woo.store.generator.service.srv.DummyStoreProcessorSrv;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

@Service
public class UbuntuDummyStoreProcessorSrvImpl implements DummyStoreProcessorSrv {

    private final Faker faker = new Faker();

    @Override
    public String generateStore(final int count) {

        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {

            String name = faker.company().name().replaceAll("[^a-zA-Z0-9]", "");
            builder
                    .append("#### Store ").append(name).append(" is generated.").append("\n")
                    .append("wp core download --path=").append(name).append("\n")
                    .append("cd /var/www/html/").append(name).append("\n")
                    .append("wp config create --dbname=").append(name).append("_db --dbuser=webuser --dbpass=password").append("\n")
                    .append("wp db create").append("\n")
                    .append("wp core install --url=http://localhost/").append(name).append(" --title=\"").append(name).append("\" --admin_user=").append("webuser").append(" --admin_password=").append("password").append(" --admin_email=webuser@localhost.wp").append("\n")
                    .append("wp plugin update --all").append("\n")
                    .append("wp plugin install user-switching woocommerce woocommerce-admin --activate").append("\n")
                    .append("wp theme install storefront --activate").append("\n")
                    .append(generateStoreProducts(1000))
                    .append("cd ..").append("\n");

        }

        return builder.toString();
    }

    @Override
    public String generatePreInstall() {
        return "curl -O https://raw.githubusercontent.com/wp-cli/builds/gh-pages/phar/wp-cli.phar\n" +
                "chmod +x wp-cli.phar\n" +
                "sudo mv wp-cli.phar /usr/local/bin/wp\n" +
                "wp --info\n";
    }

    @Override
    public String generateStoreProducts(final int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append("wp wc product create --user=webuser --name=\"").append(faker.food().dish())
                    .append("\" --regular_price=").append(RandomUtils.nextInt(0, 100))
                    .append("\n");
        }
        return builder.toString();
    }
}