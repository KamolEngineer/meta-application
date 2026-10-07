
do_install:append() {

#Enable CGI module in apache2
sed -i 's/^#\(LoadModule cgi_module \/usr\/libexec\/apache2\/modules\/mod_cgi\.so\)/\1/' ${D}/${sysconfdir}/${BPN}/httpd.conf

#Configure where cgi script is stored on rootfs
sed -i 's|ScriptAlias /cgi-bin/ "/usr/libexec/apache2/modules/cgi-bin/"|ScriptAlias /cgi-bin/ "/usr/lib/cgi-bin/"|' ${D}/${sysconfdir}/${BPN}/httpd.conf

#PErmission for cgi directory
sed -i 's|<Directory "/usr/libexec/apache2/modules/cgi-bin">|<Directory "/usr/lib/cgi-bin">|' ${D}/${sysconfdir}/${BPN}/httpd.conf

# Change DocumentRoot
sed -i 's|DocumentRoot "/usr/share/apache2/default-site/htdocs"|DocumentRoot "/var/www/html"|' ${D}/${sysconfdir}/${BPN}/httpd.conf

# Update directory for htdocs
sed -i 's|<Directory "/usr/share/apache2/default-site/htdocs">|<Directory "/var/www/html">|' ${D}/${sysconfdir}/${BPN}/httpd.conf

}