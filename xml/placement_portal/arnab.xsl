<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
    <html>
    <head>
     <link rel="stylesheet" type="text/css" href="arnab.css"/>
    </head>
	<h1 align="center">Selects </h1>
        <body>
            <table border="3" align="center" >
                <tr>					
                    <th>Companyname</th>
                    <th>roundname</th>
                    <th>studentname</th>
                    <th>rollno</th>
                    <th>status</th>
					<th>role</th>
                    <th>offertype</th>
                </tr>
                <xsl:for-each select="/Results/Company">
				<xsl:sort select="event_id" data-type="number"/>
                <tr>
                    <td><xsl:value-of select="Companyname"/></td>
                    <td><xsl:value-of select="roundname"/></td>
                    <td><xsl:value-of select="studentname"/></td>
                    <td><xsl:value-of select="rollno"/></td>
                    <td><xsl:value-of select="status"/></td>
					<td><xsl:value-of select="role"/></td>
                    <td><xsl:value-of select="offertype"/></td>
                </tr>
                </xsl:for-each>
            </table>
        </body>
    </html>
</xsl:template>
</xsl:stylesheet>